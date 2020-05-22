import java.util.*;

public class NumberGuessingGame {

static int randomNumber = (int) (Math.random() * 11);

static Scanner userInput;

static int guessedNumber;


public static void main(String[] args) {

        System.out.println("I'm thinking of a number in my mind between 0 and 10. ");

        do
        {


            delay(1500);

            System.out.print("Try to guess it: ");
            userInput = new Scanner(System.in);
            guessedNumber = userInput.nextInt();

            if (guessedNumber == randomNumber) {

                System.out.print("Congratulations! ");

                delay(800);

                System.out.println("The number really was " + randomNumber);

            } else {

                System.out.println("Error, try again! ");

                delay(800);

            }
        }
        while (guessedNumber != randomNumber);

}

public static void delay(int millis) {

   try {

           Thread.sleep(millis);

       } catch (InterruptedException exp) {
   }

}   

}