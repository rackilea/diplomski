package test;

import java.util.Scanner;
import javax.swing.JOptionPane; 

public class LoanRates {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number");
            String input = in.next();
            try {
                int rate = Integer.parseInt(input);
                // you can use the rate variable and change your method to accept the input value
                System.out.println(getNumbers(rate));
                break;
            } catch (NumberFormatException e) {
                try {
                    double rate = Double.parseDouble(input);
                    // you can use the rate variable and change your method to accept the input value
                    System.out.println(getNumbers(rate));
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid number.");
                }
            }
        }
        System.out.print("did it work?");
    }

    public static double getNumbers(double rate) {
        // rate calculation logic
        return rate;
    }

    public static int getNumbers(int rate) {
        // rate calculation logic
        return rate;
    }
}