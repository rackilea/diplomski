import java.util.Scanner;

public class BMICalc
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);

        int cw=0;
        int ch;
        double bmi;
        double wgt=0;
        double hgt;
        int ct;
        double BMIinchPoundFactor = 703;

        System.out.print("\nNote: This program is not yet fully functional.\nThere might be issues regarding decimal values. \nProgram has not been equipped to accept or display in decimal values. \nThe program will be updated soon. \nSorry for the inconvinience.");

        System.out.print("\nNote: If you choose to enter weight in Pounds, you'd have to enter height in Inches. Else, in meters");
        boolean validInput = false;
        while (!validInput) {
          System.out.print("\nEnter 1 if you want weight in Kilograms");
          System.out.print("\nEnter 2 if you want weight in Pounds\n");
          cw = input.nextInt();
          switch(cw) {
          case 1:
            System.out.print("\nEnter weight in Kilograms: ");
            wgt = input.nextDouble();
            validInput=true;
            break;
          case 2:
            System.out.print("\nEnter weight in Pounds: ");
            wgt = input.nextDouble();
            validInput=true;
            break;
          default:
            System.out.print("\nEnter a valid choice and try again!");
          }
        }
        System.out.print("\nEnter your height: ");
        hgt = input.nextDouble();

        bmi = wgt/(hgt * hgt);

        if(cw==2) bmi *= BMIinchPoundFactor;

        System.out.printf("\nYour weight is: %.0f", wgt);
        System.out.printf("\nYour height is: %.2f", hgt);
        System.out.printf("\n\nYour BMI is: %.1f", bmi);

        System.out.print("\nBMI VALUES");
        System.out.print("\nUnderweight: less than 18.5");
        System.out.print("\nNormal: between 18.5 and 24.9");
        System.out.print("\nOverweight: between 25 and 29.9");
        System.out.print("\nObese: 30 or greater\n\n");
    }
}