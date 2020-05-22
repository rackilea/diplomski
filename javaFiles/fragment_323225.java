import java.util.Random;
import java.util.Scanner;

public class NumberGame
{
    public static void main(String[] args)
    {
        final int MAX_NUMBER = 100;

        Random rand = new Random();

        int number = rand.nextInt(MAX_NUMBER) + 1;
        int on_off = 1;
        int guessCount = 0;
        int guess; 

        Scanner keyboard = new Scanner(System.in);

        while(on_off == 1)
        {
            System.out.print("Guess a number between 1 and 100: ");
            guess = keyboard.nextInt();
            guessCount++;

            if(guess < number)
            {
                System.out.println("Too Low");
                guessCount++;
            }

            if(guess > number)
            {
                System.out.println("Too High");
                guessCount++;
            }

            if(guess == number)
            {
                System.out.println("Correct! You win!");
            }
            System.out.println("Number of guesses: " + guessCount);
        }
    }
}