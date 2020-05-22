import java.util.Scanner;

public class ArrayIG 
{
    public static void main(String[] args) 
    {
        final int NUM_EMPLOYEES = 3;

        //creating array
        int[] hours = new int[NUM_EMPLOYEES];
        int[] employeeID = {5678459, 4520125, 7895122};
        double[] payRate = new double[NUM_EMPLOYEES];
        double[] wages = new double[NUM_EMPLOYEES];

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter your " + NUM_EMPLOYEES + " employees work hours and pay rate:");

        //get the hours
        for (int i = 0; i < NUM_EMPLOYEES; i++)
        {
            System.out.print("Employee #" + employeeID[i] + ": ");
            hours[i] = keyboard.nextInt();

            //get the hourly pay rate
            System.out.print("Enter the pay rate: ");
            payRate[i] = keyboard.nextDouble();

            wages[i] = hours[i] * payRate[i];
        }



        //display wages
        System.out.println("The hours and pay rates you entered are:");

        for(int i = 0; i < NUM_EMPLOYEES; i++)
        {
            System.out.printf("The total wages for Employee #%d is $%.2f\n", employeeID[i], wages[i]);
        }

    }

}