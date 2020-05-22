import java.util.Scanner;

public class Test
{

    public static void main ( String [ ] args )
    {
        System.out.print ( "Enter number: " );
        Scanner scnr = new Scanner(System.in); 

        int number = 0;
        //Check number within range 4-10
        if (scnr.hasNext ( "^[4-9]|10" )) 
        {
           number = scnr.nextInt();
           System.out.println ( "Good Number: " + number );
        }
        else{
            System.out.println ( "Is not number or not in range" );
        }

    }
}