import java.util.Scanner;

public class LesserString2 {

    public static void main(String args[]) {
        Scanner inputScanner = new Scanner(System.in);
        int result;
        String firstString;
        String secondString;

        firstString = inputScanner.nextLine();
        secondString = inputScanner.nextLine();
        result = firstString.compareTo(secondString);
        if (result == 0) {
            System.out.println("The strings are equal, please try again.");
        } else if (result < 0) {
            System.out.println("Lesser is: " + firstString);
        } else { // No need for: if (result > 0) {
            System.out.println("Lesser is: " + secondString);
        }
    }
}