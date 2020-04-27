package projetobanco;

import java.util.Scanner;

public class ProjetoBanco {
    static StringBuilder exOperacoes = new StringBuilder(); 
    static Scanner ler = new Scanner(System.in);
    
    static int opcao;
    static String CPF = "123.456.789-00";
    static String senha = "01020304";
    static double saldo = 1000.00;
    
    static int opDesejada;
    
    static String agencia = "0001";
    static String conta = "1362204-5";
    static String banco = "Inter";
    static double transf;
    
    static double deposito;
    static double saque;
     
    static String ex;
    
   
            
    static void opcaoDesejada(){
        System.out.println("");
                
        System.out.println("O que deseja fazer?");
        System.out.println("1 - REALIZAR NOVA OPERAÇÃO");
        System.out.println("2 - SAIR DO SISTEMA");
                
        System.out.println("");
                
        opDesejada = ler.nextInt();
        
        switch(opDesejada){
                    case 1:
                        opcoes();
                    case 2:
                        inicio();
                }
        
    }
    
        static void opcoes(){
        
        System.out.println("");
        System.out.println("1 - SALDO");
        System.out.println("2 - DEPÓSITO");
        System.out.println("3 - SAQUE");
        System.out.println("4 - TRANSFERÊNCIA");
        System.out.println("5 - EXTRATO");
        System.out.println("0 - SAIR");
        System.out.println("");
        
        opcao = ler.nextInt();
        
        switch(opcao){
            case 1:
                System.out.println("");
                System.out.println("SALDO ATUAL: R$ " + saldo);
                                                     
                opcaoDesejada();
                
            case 2:
                System.out.println("");
                System.out.println("Digite o valor a ser depositado: ");
                deposito = ler.nextDouble();
                saldo +=  deposito;
                System.out.println("");
                System.out.println("SALDO ATUAL: R$ " + saldo);
                
                ex = "DEPÓSITO + R$ " + deposito;
                exOperacoes.append(ex);
                exOperacoes.append(System.getProperty("line.separator"));
                
                opcaoDesejada();
            
            case 3:
                System.out.println("");
                System.out.println("Digite o valor a ser sacado: ");
                saque = ler.nextDouble();
                saldo -=  saque;
                System.out.println("");
                System.out.println("SALDO ATUAL: R$ " + saldo);
                
                ex = "SAQUE: - R$ " + saque;
                exOperacoes.append(ex);
                exOperacoes.append(System.getProperty("line.separator"));
                
                opcaoDesejada();
                
            case 4:                
                System.out.println("Digite o Valor: ");
                transf = ler.nextDouble();
                
                System.out.println("Digite a Conta: ");
                String userCONTA = ler.next();
                
                System.out.println("Digite a Agencia: ");
                String userAGENCIA = ler.next();
                
                System.out.println("Digite o Banco: ");
                String userBANCO = ler.next();
                
                
                if(userCONTA.equals(conta) 
                    && userAGENCIA.equals(agencia)
                    && userBANCO.equals(banco) 
                    && transf < saldo){
                    
                    System.out.println("");
                    System.out.println("TRANSFERENCIA EFETUADA");
                    
                    saldo -= transf;
                    System.out.println("");
                    
                    System.out.println("Saldo Atual: " + saldo);
                    System.out.println("");
                    
                    ex = "TRANSFERÊNCIA: - R$ " + transf;
                    exOperacoes.append(ex);
                    exOperacoes.append(System.getProperty("line.separator"));
                    
                    opcaoDesejada();
                }else {
                    System.out.println("");
                    System.out.println("Houve algum erro na operação,"
                            + " tente novamente");
                    
                    opcoes();
                }
             
                    
                
                
            case 5: 
                System.out.println("Seu extrato é: ");
                System.out.print(exOperacoes);
                System.out.print("SALDO ATUAL: R$ " + saldo);
                opcaoDesejada(); 
               
            case 0:
                
                inicio();
                            
            default:
                System.out.println("Tecla Incorreta");
                opcoes();
                System.out.println("");
           }
        
    }


    static void senha(){
                 
       System.out.println("Digite sua : ");
        
        for (int i = 0; i <= 1; i++){
            
            String userSENHA = ler.next();
            
            if(senha.equals(userSENHA) == true ){
                System.out.println("Acertou");
                opcoes();
                
            } else {
                System.out.println("Errou");
                System.out.println("");
                System.out.println("Digite sua senha novamente: ");
            }                                
        } 
        
        System.out.println("");
        
        for (int i = 0; i<12; i++){
            System.out.println("");
        }
        System.out.println("Seu cartão foi bloqueado");
        inicio();
}
    
    static void inicio(){
        System.out.println("__________________");
        System.out.println("| SEJA BEM-VINDO |");
        System.out.println("| SAMUKA'S  BANK |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        
        System.out.println("Digite seu CPF: ");
        
        String userCPF = ler.next();
        
        if(CPF.equals(userCPF) == true){
            
            senha();
            
        } else{
            System.out.println("________________________________");
            System.out.println("| TELA DE ACESSO NÃO PERMITIDA |");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
                        
            inicio();
        }            
    }
        
    public static void main(String[] args) {
        inicio();
    }
    
}
