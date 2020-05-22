package com.stackoverflow.q42588622;

import java.util.Scanner;

@SuppressWarnings("javadoc")
public class Answer {

    public static void main(String[] args) {

        // get in the habit of cleaning up resources
        try (Scanner keyboard = new Scanner(System.in)) {

            // initial amount
            System.out.println("Enter the initial amount: ");

            final int initialBalance = keyboard.nextInt();

            int numItems = 0;

            // Same concept as balance
            // Only dealing with ints 
            // double assets = 0.0;

            int balance = initialBalance;

            // Spending is initially 0.
            // Only dealing with ints
            // double spending = originalPrice - assets;

            int spending = 0;

            if (initialBalance <= 10) {
                System.out.println("Please save money and come back later!!");
                numItems = 1;
                spending = 0;
            } else {

                while (balance > 10) {

                    System.out.println("Do you want to make purchases (Y/N)? ");

                    char c = keyboard.next()
                        .charAt(0);

                    if (c == 'Y' || c == 'y') {
                        System.out.println("Please enter the price of the item = ");
                    }

                    else {
                        System.out.println("Lack of desire of Mr.Toto");
                        break;
                    }

                    int price = keyboard.nextInt();

                    if (balance - price >= 10) {
                        System.out.println("A purchase is accepted");
                        balance -= price;
                        spending += price;
                        // Removing as initialBalance is immutable
                        // assets = initial - price;
                        numItems++;
                    }

                    else {
                        System.out.println("Insufficient assets!!");
                        System.out.println("Please enter the price of the item = ");
                    }
                    if (numItems == 10) {
                        System.out.println("Maximal number of purchases reached");
                        break;
                    }

                }
            }
            // displaying the summary of mr totos purchases
            System.out.println("-------------------------------------------");
            System.out.println("Here is a summary of Mr.Toto's purchases.");
            System.out.println("-------------------------------------------");
            System.out.println("Number of items     Assets      Spending");
            System.out.println("    " + numItems + "                " + balance + "   " + "       " + spending);

        }

    }

}