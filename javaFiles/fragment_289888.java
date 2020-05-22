import java.util.Scanner;

public class feetToMeters {

  public static void main (String [] args) {   
  Scanner input = new Scanner (System.in);

  System.out.println ("Enter a value for feet: ");
  double value = input.nextDouble();
  double meters = value/3.2808;
  System.out.println (value + " feet is " + meters + " meters ");

    }
}