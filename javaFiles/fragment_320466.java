package hangman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String start;
        System.out.print("Welcome to Hangman!");
        System.out.println("Type start to begin!");
        Scanner myScanner = new Scanner(System.in);
        start = myScanner.next();
        while (!"start".equals(start)) {
            System.out.println("You must type start to begin!");
            start = myScanner.next();
        }
        System.out.println("Thanks for typing start!");
    }
}