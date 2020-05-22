import java.util.Scanner;

public class calculations {
    public static void main(String[] args) {

        Scanner Keyboard = new Scanner(System.in);

        System.out.println("Enter 4 integer numbers here: ");

        // Scan an entire line (containg 4 integers separated by spaces):
        String lineWithNumbers = Keyboard.nextLine();
        // Split the String by the spaces so that you get an array of size 4 with
        // the numbers (in a String).
        String[] numbers = lineWithNumbers.split(" ");

        // For each String in the array, print them to the screen.
        for(String numberString : numbers) {
            System.out.println(numberString);
        }

    } // End main string args here
} // End class calculations here