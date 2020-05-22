import java.util.*;

public class MarblesApp
{
    private final static int MAX = 1000000000;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) 
    {
        int numberOfMarbles, numberOfPeople, marblesPerPerson, marblesLeftOver;

        System.out.println("Welcome to the marble divvy-upper.");
        System.out.println("This program will tell you how many marbles to give to each person.\n"
    + "The maximum amount of marbles is 1 000 000 000. The maximum amount of people is the same.\n");

        System.out.println("Number of marbles to divide: ");
          numberOfMarbles = getNumberFromConsole();

        System.out.println("Number of people: ");
          numberOfPeople = getNumberFromConsole();

        marblesPerPerson = (int)numberOfMarbles / numberOfPeople;
        marblesLeftOver = (int)numberOfMarbles % numberOfPeople;

        System.out.println("Give each child " + marblesPerPerson + " marbles."); 
        System.out.println("You will have " + marblesLeftOver + " marbles left over.");
    }

    public static int getNumberFromConsole()
    {
        int number;

        while (true)
        {
            try 
            {   
                // get the number from console
                number = input.nextInt();

                // validate whether it's greater zero and lower MAX
                if(validateNumber(number) == true) 
                {
                    // if true, return the number
                    return number;
                } 
                else
                {
                    // if not, input again
                    input.next(); 
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a number not a word\nTry again: ");
                input.next(); 
            }
        }
    }

    private static boolean validateNumber(int number) {

        if(number > MAX || number == 0)
        {
            System.out.println("Please enter a number under 1 000 000 000 and above 0\nTry again: ");
            return false;
        }

        return true;
    }
}