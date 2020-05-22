/* reads a char, a space, or a period from keyboard, returns user input,
   counts number of spaces and total number of entries */
package ch03_36_exercise_01;

import java.util.Scanner;

public class Ch03_36_Exercise_01 {

    public static void main(String args[]) throws java.io.IOException {

        Scanner userInput = new Scanner(System.in);
        char keystroke;           // character that user enters
        int ctr = 0, spaces = 0;  // num of tries to stop run, num of spaces entered

        do {
            // ask for user input
            System.out.print("Enter a character, or hit the space bar,"
                    + " or enter a period to stop: ");
            keystroke = userInput.nextLine().charAt(0);

            if (Character.isSpaceChar(keystroke)) {
                System.out.println("You entered a space");
                spaces++; // increment space bar count
            } else {
                System.out.println("You entered a " + keystroke);
            }

            // increment keystroke count
            ctr++;
        } while (keystroke != '.');

        System.out.print("It took " + ctr + " tries to stop");

        if (spaces > 0) {
            System.out.println(" and you hit the space bar " + spaces + " times\n");
        }
    }
}