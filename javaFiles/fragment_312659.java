import java.util.InputMismatchException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\tBasic Factorial Calculator");
        System.out.println();

        int number = getNumber();
        System.out.println();
        output(number);
    }

    public static int getNumber()
    {
        int Num = 0;
        boolean done = false;
        Scanner input = new Scanner(System.in);
        while(!done)
        {
            try
            {
                System.out.println("Enter the number you want to find a factorial of: ");
                Num = input.nextInt();
                if (Num <= 0) throw new InputMismatchException();
                done = true;
            }
            catch(InputMismatchException e)
            {
                System.out.println("");
                System.out.println("Error, enter a number greater than 0");
                input.nextLine();
                System.out.println("");
            }
        }
        return Num;
    }
    public static void output(int Num)
    {
        System.out.println();
        long factorial = 1;
        for(int i = 1; i <= Num; i++)
        {
            factorial = factorial * i;
        }
        System.out.println("The factorial of " + Num + " is " +
                factorial + ".");
    }
}