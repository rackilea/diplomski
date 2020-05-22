import java.util.Scanner;
import java.util.Random;

public class DoGuessingGame
{
    public static void main(String[] args) {

    int number1, userInput; //assign vars
    int tries = 0;

    Random rand = new Random();     
    Scanner keyboard = new Scanner(System.in);  //define Random and scanner input 

    System.out.println("Welcome to the Guessing Game!");
    System.out.println("-----------------------------");

    number1 = rand.nextInt(20) + 1;

    do
    {
        System.out.println("\nI'm thinking of a number between 1 and 20. Enter -1 if you would like to quit");
        userInput = keyboard.nextInt();
        tries++;
         if (userInput > 0 && userInput < 21) {
            if(userInput == number1) {
                System.out.println("That is the correct number");
                System.out.println("The Number of tries: " + tries);
                System.out.println("Game Over.");
                userInput = -1;
            } else if(userInput > number1) {
                System.out.println("Your number is too high");
                System.out.println("Please try again");
            } else if(userInput < number1) {
                System.out.println("Your number is too low");
                System.out.println("Please try again");
            }
        } else {
            System.out.println("Please enter a number between 1 and 20");
        }
    } while(userInput != -1);
    System.out.println("The number of tries: " + tries);
}