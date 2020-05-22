//EDIT: added new import to help with validating user input
import java.util.InputMismatchException;
import java.util.Scanner;
//EDIT: removed import that is no longer needed, see code changes below
//import java.io.BufferedReader;
import java.io.IOException;
//EDIT: removed import that is no longer needed, see code changes below
//import java.io.InputStreamReader;
import java.util.Random;

//EDIT: changed class name to java standard naming convention using uppercase for first letter.
public class StringVariables {

    // EDIT: this variable is not used, I removed it
    // private static boolean isValid;

    public static void main(String[] args) throws NumberFormatException,
            IOException {

        // user inputs their name in this section
        Scanner user_input = new Scanner(System.in);

        String first_name;
        System.out.print("Enter Your First Name: ");
        first_name = user_input.next();

        String last_name;
        System.out.print("Enter Your Last Name: ");
        last_name = user_input.next();

        String full_name;
        full_name = first_name + " " + last_name;

        System.out.println(full_name + " Is Now Playing");

        // this is the shuffle portion as well as something to see if a number
        // is not inputed
        // EDIT: removed this variable as it is no longer used in the code that
        // follows.
        // boolean testing = false;
        // EDIT: Removed this variable in favor of using Scanner.nextInt() in
        // the code below
        // String pos = "";

        // EDIT: Added this variable and initialized to an invalid value so that
        // we can loop until a valid value is entered.
        int numShuffles = -1;
        while (numShuffles < 0) {
            // EDIT: This variable is not needed with the new logic
            // testing = false;
            // EDIT: This is not needed, you already have a Scanner object above
            // called user_input
            // Scanner sc = new Scanner(System.in);
            System.out
                    .println("How many times do you want the numbers shuffled? ");

            try {
                // EDIT: modified the lines below to fix infinite loop, forgot
                // about certain Scanner behavior so switched back to
                // Integer.parseInt
                String inputText = user_input.next();
                numShuffles = Integer.parseInt(inputText);
            } catch (NumberFormatException inputException) {
                System.out.print("Please enter a valid number. ");
            }
        } // EDIT: added closing bracket here
            // EDIT: none of the code commented out below is needed when using
            // the new code above.
        // for(int i=0; i<pos.length();i++)
        // {
        // if(!Character.isDigit(pos.charAt(i)))
        // testing = true;
        // }
        // if(testing == true)
        // {
        // System.out.print("Enter only numbers..   ");
        // continue;
        // }
        //
        // else
        // {
        // int key = Integer.parseInt(pos);
        //
        //
        // break;

        // here is going to be the loop for shuffles

        // we are now going to generate their random number and add a delay
        // after completing their name fields

        delay(2000);
        System.out
                .println(" You will be given a hand  of 3 random numbers between 7-13");

        delay(2000);
        System.out
                .println(" Then, the computer will add the random numbers and  if it is equal to 31, you win.");

        /*
         * end of explanation of the game, next i will create a new screen with
         * the user's name and numbers
         */

        delay(4000);
        // EDIT: rather than repeating the same code over and over just use a
        // loop if you want to print 25 blank lines.
        for (int i = 0; i < 25; i++)
            System.out.println(" ");
        // EDIT: see previous comment, removed duplicate code
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");
        // System.out.println(" ");

        System.out.println("User playing: " + full_name);

        System.out.println("Your lucky numbers are...");

        // random number generator
        // EDIT: This BufferedReader is not needed with changes to code below
        // BufferedReader br = new BufferedReader(new
        // InputStreamReader(System.in));
        Random random = new Random();

        // EDIT: removed the following two lines to simplify the looping logic
        // int ch = 1;
        // while (ch == 1) {
        while (true) {

            // EDIT: your comment is wrong, you're creating 3 numbers here not 2
            // get two random numbers between 7 and 13
            // EDIT: no need to create a new Random inside the loop, you can
            // re-use a single instance.
            // Random r = new Random();
            // EDIT: This approach is fine, but I think using the Random class
            // is easier to read so I replaced your code with code that uses
            // Random
            // int num1 = 7 + (int) (Math.random() * (7));
            // int num2 = 7 + (int) (Math.random() * (7));
            // int num3 = 7 + (int) (Math.random() * (7));

            // EDIT: based on your replies it seems like you want to give the user
            // several changes for each run of the game and this is what you meant
            // by "shuffle". I have implemented that feature below with the for loop.
            boolean isWinner = false;
            for (int i = 0; i < numShuffles; i++) {
                int num1 = 7 + random.nextInt(7);
                int num2 = 7 + random.nextInt(7);
                int num3 = 7 + random.nextInt(7);

                System.out.println(num1 + " + " + num2 + " + " + num3 + " = "
                        + (num1 + num2 + num3));

                // EDIT: you never use the variable i so I removed this code.
                // int i = 0;
                // {
                // System.out.println(num1 + num2 + num3);
                // i++;
                // }

                if (num1 + num2 + num3 == 31) {
                    isWinner = true;
                    System.out
                            .println("Congratulations !! You are the Lucky Winner !!!!");
                    break;
                }
            }
            if (!isWinner)
                System.out.println("Better Luck Next Time");

            // the play again menu. this blocks any input besides 1 or 0

            // EDIT: again, re-use the existing scanner
            // Scanner sc = new Scanner(System.in);
            // EDIT: There is a much simpler and easier-to-read way to do this
            // so I have removed your code and added new code after.
            // EDIT: Also this code does not work correctly, it fails to exit
            // properly when the user enters a letter.
            // while (true) {
            // System.out.println("Want To Play Again ? ANY # = YES, ANY LETTER = NO");
            // String input = user_input.next();
            // int intInputValue = 0;
            // try {
            //
            // intInputValue = Integer.parseInt(input);
            // Integer.parseInt(input);
            // break;
            // } catch (NumberFormatException ne) {
            // System.out.println("Input is not a number, type 1 to continue, or any letter to quit");
            //
            // ch = Integer.parseInt(br.readLine());
            // }
            //
            // }
            // EDIT: here is the new code, see previous comment.
            System.out
                    .println("Do you want to play again? (If you do enter y or yes) ");
            String input = user_input.next();
            if (!"y".equalsIgnoreCase(input) && !"yes".equalsIgnoreCase(input)) {
                break;
            }
        }

        // EDIT: close the scanner when you're finished with it.
        user_input.close();
    }

    // delay field

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {

            // delay field

        }
    }
}