import java.util.InputMismatchException;
import java.util.Scanner; // This will import just the Scanner class.

public class GuessAge {
public static void main(String[] args) {
   System.out.println("\nWhat is David's Age?");
   Scanner userInputScanner = new Scanner(System.in);
   int age = userInputScanner.nextInt();



    int validInput = 20;

    // typo in your code - compare to age
    if (validInput == age) {
        System.out.println("Correct!!");
    }
    else {
        System.out.println("Wrong....");
    }
}

}