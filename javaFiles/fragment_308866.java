package example.stackoverflow;

import java.util.Scanner;

public class AgeChecker
{
    public static final int MIN_AGE = 0;
    public static final int MAX_AGE = 125;

    static class InvalidAgeException extends Exception
    {
        private static final long serialVersionUID = 1340715735048104509L;

        public InvalidAgeException()
        { }

        public InvalidAgeException(String message)
        {
            super(message);
        }

        public InvalidAgeException(String message, Throwable cause)
        {
            super(message, cause);
        }
    }

    public static void main(String[] args)
    {
        Scanner inputdata = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = inputdata.nextLine();
        System.out.print(name+", enter your age: ");
        int age = inputdata.nextInt();
        try
        {
            System.out.println("You entered: "+age);
            // Assuming age limits are non-inclusive
            if( (age <= MIN_AGE) || (age >= MAX_AGE) )
            {
                throw new InvalidAgeException("Out of range error! (must be between ages 0 and 125)");
            }
        }
        catch(InvalidAgeException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Age Checking Complete.");
            if(inputdata != null)
            {
                inputdata.close();
            }
        }
    }
}