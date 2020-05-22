package hangman;

import java.util.Scanner;

/**
 *
 * @author Adam2_000
 */
public class Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String selection;
        Scanner scan = new Scanner(System.in);

        /*
         *  I moved the variables found here to the Game class 
         */

        //New instances of class and arrays
        Words words = new Words();


        System.out.println("Welcome to Hangman version 1");
        System.out.println("Please choose a difficulty");
        System.out.println("A: Easy");
        System.out.println("B: Medium");
        System.out.println("C: Hard");
        System.out.println("X: Exit");      // Just for user friendlyness

        System.out.println(" _________     ");
        System.out.println("|         |    ");
        System.out.println("|         0    ");
        System.out.println("|        /|\\  ");
        System.out.println("|        / \\  ");
        System.out.println("|              ");
        System.out.println("|              ");

        char iChoice;

        do {
            selection = scan.nextLine().toUpperCase();
        } while (selection.isEmpty());

        iChoice = selection.charAt(0);
        if (iChoice != 'X') {
            switch (iChoice) {
                case 'A':
                    System.out.println("You have chosen easy:");
                    new Game(words.easyWords, scan);                //All three levels can be called from the same class with the same code.
                    break;                                          //This will help reduce amount of code, and help when you need to change all three at once.

                case 'B':
                    System.out.println("You have chosen Medium");
                    new Game(words.mediumWords, scan);              //Called with the String[] of words you want to use and the scanner to save memory.
                    break;

                case 'C':
                    System.out.println("You have chosen Hard");
                    new Game(words.hardWords, scan);
                    break;
            }
        }
    }
}