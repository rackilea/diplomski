package whateverpackage;

import java.util.Scanner;

public class Method {

    // Method accepts a Scanner Object as an argument.
    public void passingParameters(Scanner input){
        System.out.println("Enter a integer value for Parameter: ");
        int numInput = input.nextInt();
        input.nextLine(); // Empty scanner buffer
        System.out.println("Supplied value was: " + numInput);
    }
}