package banking;

import java.util.Random;
import java.util.Scanner;

public class BankMain {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your Name: ");
        String customerName = input.nextLine();

        Random randomGenerator = new Random();
        int acctNo = randomGenerator.nextInt(100000);

        System.out.println("Enter Initial Balance: ");
        int balance = input.nextInt();

        BankAccount acct = new BankAccount(customerName, acctNo, balance);

        System.out.println("Menu");
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Display Information");
        System.out.println("4. Exit");

        boolean quit = false;
        int menu;
        do {
            final int transaction;
            System.out.print("Please enter your choice: ");
            menu = input.nextInt();
            switch (menu) {
                case 1:
                    System.out.print("Enter depost amount:");
                    transaction = input.nextInt();
                    acct.deposit(transaction);
                    break;

                case 2:
                    System.out.println("Current Account Balance=" + acct.getBalance());
                    System.out.print("Enter withdrawal amount:");
                    transaction = input.nextInt();
                    try {
                        acct.withdraw(transaction);
                    } catch (IllegalArgumentException iaEx) {
                        System.out.println(iaEx.getMessage());
                    }
                    break;

                case 3:
                    acct.display();
                    break;

                case 4:
                    quit = true;
                    break;
            }
        } while (!quit);
    }
}