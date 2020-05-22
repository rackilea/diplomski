import java.util.Scanner;

public class BankInterest {
    static public double annualInterest(double balance, double interestRate) {
         int years = 0;
         while (years < 10) {
            double interest = balance * interestRate;
            balance = balance + interest;
            years++;
        }

        return balance;
    }

    static public double monthlyInterest(double balance, double interestRate) {
      int months = 0;
         while (months < 120) {
            double interest = balance * interestRate/12;
            balance = balance + interest;
            months++;
        }

        return balance;
    }

    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your balance: ");
        double balance = keyboard.nextDouble();
        System.out.println("Please enter the ann1ual interest rate in decimal form: ");
        double interestRate = keyboard.nextDouble();

        System.out.println("Balance after 10 years with annual interest is " + 
        annualInterest(balance, interestRate));
        System.out.println("Balance after 10 years with monthly interest rate is " + 
        monthlyInterest(balance, interestRate));
    }
}