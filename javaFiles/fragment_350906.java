import java.util.Scanner;

public class NestedIf
{
    public static void main (String [] args)
    {

        System.out.println ("Who is the presiden of USA?");

        String response ="";
        String answer;

        answer = "Obama";

        Scanner input = new Scanner (System.in);
        response = input.nextLine();

        if (response.equals(answer))
        {
            System.out.println ("That is right");
        }
        else
        {  
            System.out.println ("That is wrong");
        }
            response = input.nextLine();

            if (response.equals(answer))
            {
                System.out.println ("That is right");
            }
            else
            { 
                System.out.println ("That is wrong");
            }
                response = input.nextLine();

                if (response.equals(answer))
                System.out.println ("That is right");
                else 
                System.out.println ("That is wrong - Bye");


    }
}