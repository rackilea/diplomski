import java.util.Scanner;
public class Exercise2_6M
{
    public static void main(String[] args) 
    {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Enter amount
        System.out.print("Enter an integer: ");
        int integer = input.nextInt();

        // Calculations
        int rinteger = Math. abs (integer);
        int sum = 0;
        int i=0;

        //loop through each digit (starting from the least significant) until the end of the number
        while(rinteger / Math.pow(10,i) > 0)
        {
            sum+=getDigit(rinteger,i);
            i++;
        }


        // Display results
        System.out.println("Sum all digits in " + integer + " is " + sum);
    }

    public static int getDigit(int num, int power)
    {
        return (num % (int)Math.pow(10,power+1)) / (int)Math.pow(10,power);
    }
}