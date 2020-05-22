import java.util.*;

public class Pattern
{

    public static void main(String[] args)
    {

        int input;
        Scanner kb = new Scanner(System.in);    

        System.out.print("Enter a positive number: ");
        input = kb.nextInt();

        while (input <= 0)
        {
            System.out.print("That isn't positive, try again: ");
            input= kb.nextInt();
        }

        for (int number = 0; number < input; number++)
        {
            System.out.print("#");

            //print spaces equal to the number variable
            for(int count = 0; count < number; count++)
            {
                System.out.print(" ");
            }

            System.out.println("#");
        }               

    }

}