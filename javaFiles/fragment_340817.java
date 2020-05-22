import java.text.DecimalFormat;
import java.util.Scanner;


public class Main {

static DecimalFormat df;

public static void inchToCentimeter(double a)

{
    System.out.println("Inches      " + "Centimeters");
    System.out.print("\n");

    for (double i = 1.0; i <= a; i++)

    {
        double cm = i * 2.54;
        System.out.println(i + "        " + df.format(cm)); 
    }
} 

public static void centimeterToInch(double b)

{
    System.out.print("\n");
    System.out.println("Centimeters     " + "Inches");
    System.out.print("\n");

    for (double i = 1.0; i <= b; i++)

    {
        double inch = i / 2.54;
        System.out.println(i + "        " + df.format(inch)); 
    }
 }

  public static void main(String args[])

  {
    Scanner newScanner = new Scanner(System.in);
    df = new DecimalFormat("0.00");
    System.out.println("Please enter 2 numbers :\n" + "Number a for the conversion from inch to centimeter,\n"
        + "while number b for the conversion from centimeter to inch");
    System.out.println("Number a : ");
    double c = newScanner.nextDouble();
    System.out.println("Number b : ");
    double d = newScanner.nextDouble();
    inchToCentimeter(c);
    centimeterToInch(d);
  }