import java.util.Scanner;

/**
 * Software Development 1, Lab 3 Task 1: Write a program to calculate the
 * magnitude of a 2D vector The magnitude calculation should take place in a
 * separate method.
 */
public class OneVector {
    static double a,b;
    public static void main(String[] args) {
        readComponents();
        double magnitude = calculateMagnitude(a,b);
        displayMag(magnitude);
    }

    // TODO: Read in the two components from the user
    public static void readComponents() {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter a value for vector 1");
        a = scan.nextDouble();
        System.out.println("enter a value for vector 2");
        b = scan.nextDouble();
    }

    // TODO: Use the calculateMagnitude method to find its magnitude
    static void calculateMag() {

    }

    // TODO: Display the vector's magnitude to the user
    public static void displayMag(double magnitude) {
        System.out.println(magnitude);

    }

    /*
     * Calculates the magnitude of a 2D vector.
     */
    public static double calculateMagnitude(double a, double b) {
        // TODO: Write code to calculate the vector's magnitude
        double magnitude = Math.sqrt((a * a) + (b * b));

        // TODO: Return the calculated magnitude to the main method
        return magnitude;
    }
}