//Arthur Fidas
import java.util.Scanner;   //Needed for Scanner class
import java.lang.String;
/**
    This program computes and displays the shipping charges for Fed Ex.
*/

public class FedEx
{
    public static void main (String[] args)
    {
        final double ZONE_A = .6, ZONE_B = 1.0, ZONE_C = 1.25, ZONE_D = 1.4;
        String input;
        char zone;
        String name;
        double weight;
        double total = 0.0;
        int serviceCode;
        int hazardCode;
        double hazardCodeCalculation;

        //Create a Scanner object for keyboard input
        Scanner keyboard = new Scanner (System.in);

        //Prompt user for package weight
        System.out.println("What is the weight of the package?: ");
        weight = keyboard.nextDouble();

        /*THIS FOLLOWING PORTION CAN BE CHANGED WITH PROVIDED SOLUTIONS, TRY ANY OF THEM*/

        //Prompt user for Zone                             
        System.out.print("Enter the zone letter: ");
        input = keyboard.next();
        zone = input.charAt(0);

        /*TILL THIS*/

        //Calculate zone price
        switch(zone)
        {
            case 'a':
            case 'A':
                total = weight*ZONE_A;
                break;
            case 'b':
            case 'B':
                total = weight*ZONE_B;
                break;
            case 'c':
            case 'C':
                total = weight*ZONE_C;
                break;
            case 'd':
            case 'D':
                total = weight*ZONE_D;
                break;
            default:
                System.out.println("Please enter A, B, C, or D.");
                break;
        }

        //Prompt user for service charge
        System.out.println("Enter the Special Service number: ");
        serviceCode = keyboard.nextInt();

        //Caculate Service Charge
        if (serviceCode == 1)
        {
            total += 0;
        }
        else if (serviceCode == 2)
        {
            total += 10;
        }
        else if (serviceCode == 3)
        {
            total += 25;
        }
        else
        {
            System.out.println("Please enter 1, 2, or 3.");
        }
        //Prompt user for Hazard Code
        System.out.println("Enter the Hazard Code number :");
        hazardCode = keyboard.nextInt();

        //Calculate Hazard Charge
        switch(hazardCode)
        {
            case 1:
                total += 0;
                break;
            case 2:
                hazardCodeCalculation = total * .1;
                total += hazardCodeCalculation;
                break;
            case 3:
                hazardCodeCalculation = total * .25;
                total += hazardCodeCalculation;
                break;
            default:
                System.out.println("Please enter either 1, 2, or 3.");
                break;
        }
    }
}