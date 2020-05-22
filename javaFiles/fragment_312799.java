import java.util.InputMismatchException;
import java.util.Scanner; 
public class AreaCircle { 
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); // read the keyboard
        System.out.println("This program will calculate the area of a circle");
        System.out.println("Enter radius:");//Print to screen
        try {
            double r = sc.nextDouble(); // Read in the double from the keyboard
            double area = (3.14 *r * r);

            String output = "Radius: " + r + "\n";
            output = output + "Area: " + area + "\n";
            System.out.println("The area of the circle  is " + area);

        }
        catch( InputMismatchException e ) {
            System.out.println("Invalid Input, please enter a number");
            //put a message or anything you want to tell the user that their input was weird.
        }
        catch( NumberFormatException e ) {
            System.out.println("Invalid Input, please enter a number");
            //put a message or anything you want to tell the user that their input was weird.
        }
    }
}