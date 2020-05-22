package com.amit;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        boolean option = true;
        Scanner scanner = new Scanner(System.in);
        while (option){
            System.out.println("Press 1 For Deposite. Press 2 For Withdrawal. Press 3 For Exit");
            boolean hasvalue = scanner.hasNextInt();
            if(hasvalue){
                //means user has entered integer value now check if its in 1, 2 if  its other
                // than this we'll take him out of program to print balance
                int userValEntered = scanner.nextInt();
                if (userValEntered == 1){
                    //code for deposite
                    System.out.println("Enter Amount To Deposite");
                    Scanner amountToDeposite = new Scanner(System.in);
                    account.setBalance(amountToDeposite.nextDouble());
                }else if (userValEntered == 2) {
                    //Code for withdrawal
                    System.out.println("Enter Amount To Withdraw");
                    Scanner amountToWithdraw = new Scanner(System.in);
                    double withdrawAmt = amountToWithdraw.nextDouble();
                    if (withdrawAmt >= account.getBalance()){
                        System.out.println("Unable to Withdraw Given Amount, Try Other Amount");
                        continue;
                    }else {
                        double currentBalance = account.getBalance() - withdrawAmt;
                        account.setBalance(currentBalance);
                        System.out.println("Thanks for Doing Business With us");
                    }
                }else{
                    //if user enters anything other than 1 or 2
                    break;
                }

            }else {
                //if user enters anything other than integer
                break;
            }

        }
        //code to print balance here.
        System.out.println("Your Balance is: "+account.getBalance());
    }
}