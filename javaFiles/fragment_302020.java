package whateverpackage;

import java.util.Scanner;

public class Method {

    // Declare a Scanner Object field.
    // This will make the Object global
    // to the entire Class.
    private Scanner scannerInput;

    // Class Constructor
    public Method (Scanner input) {
        this.scannerInput = input;    
    }

    public void passingParameters(){
        System.out.println("Enter a integer value for Parameter: ");
        int numInput = scannerInput.nextInt();
        input.nextLine(); // Empty scanner buffer
        System.out.println("Supplied value was: " + numInput);
    }
}