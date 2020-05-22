import java.util.Scanner;

public class Triangle {

    // declare a scanner for user input
    Scanner input = new Scanner(System.in);

    public int getInput() { // method to take user input

        System.out.print("Enter the number of lines: ");
        int numLines = input.nextInt();

        // include an if statement to make sure that the number of lines that
        // the user inputs is greater than zero
        if (numLines <= 0) {
            System.out.println("Number of lines is negative. Exiting.");
            System.exit(0);
        }
        return numLines;
    }

    public void printTriangle() {
        int numLines = getInput();
        // This for loops prints one line for each iteration.
        for (int i = 0; i < numLines; i++) {
            // This for loop takes care of the preceding spaces in each line.
            for (int j = 0; j < numLines - i - 1; j++)
                System.out.print(" ");

            // This for loop prints the required number of characters in each
            // line.
            for (int k = 0; k <= i; k++)
                System.out.print("* ");

            // We are done with a line. Moving on to the next one.
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Triangle obj = new Triangle(); // create object
        obj.printTriangle(); // call using object
    }
}