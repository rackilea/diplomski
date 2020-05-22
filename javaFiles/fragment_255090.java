/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class StringInABox {

    public static void printSpaces(int phraseLength) {
        for (int space = 0; space < 2 * (phraseLength - 1) - 1; space++) {
            System.out.print(" ");
        }
    }

    public static void printTopRow(String capPhrase, int phraseLength) {
        for (int letter = 0; letter < phraseLength; letter++)
            System.out.print(capPhrase.charAt(letter) + " ");
        System.out.println();
    }

    public static void printIntermediateBoxRows(String capPhrase, int phraseLength) {
        for (int letter = 1; letter < phraseLength - 1; letter++) {
            int indexFromFront = letter;
            int indexFromBack = phraseLength - 1 - letter;
            System.out.print(capPhrase.charAt(indexFromFront));
            // Print required spaces
            printSpaces(phraseLength);
            // End space print
            System.out.print(capPhrase.charAt(indexFromBack));
            System.out.println();
        }
    }

    public static void printLastRow(String capPhrase, int phraseLength) {
        for (int letter = phraseLength - 1; letter >= 0; letter--)
            System.out.print(capPhrase.charAt(letter) + " ");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a phrase or word!");
        String phrase = scan.nextLine();
        String capPhrase = phrase.toUpperCase();
        int phraseLength = capPhrase.length();

        // Print the box
        printTopRow(capPhrase, phraseLength);
        printIntermediateBoxRows(capPhrase, phraseLength);
        printLastRow(capPhrase, phraseLength);
    }
}