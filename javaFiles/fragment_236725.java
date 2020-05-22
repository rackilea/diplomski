package com.stackOverflow.practice.banking;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.Collator;


public class App {

        public static void main(String... args) throws IOException, MyException{

        ArrayList<Account> ac = new ArrayList<Account>();
        Scanner scan = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning){
              System.out.println("Please enter your name in the account(quit to exit program): ");
              String name = scan.next();
              if(name.equalsIgnoreCase("quit")) {
                  break;
              }
              System.out.println("Please enter an amount for your account: ");
              double amount = scan.nextDouble();
              Account a = new Account(name, amount);
              ac.add(a);

         }

         for(Account t: ac) {
              System.out.println("Name: " + t.getName() + "\nAmount: " + t.getAmount());
              System.out.println();
         }

    }
}