import java.util.Scanner;

public class Numbers3 {

    private static final int NUM_RUNS = 3;

    // starts execution of java application
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < NUM_RUNS; i++) {

            // First input field
            System.out.print("Input first number: ");
            int firstNumber = input.nextInt();
            // Second input field
            System.out.print("Input second number: ");
            int secondNumber = input.nextInt();

            System.out.printf("%d is a multiple of %d: %s%n%n",
                    firstNumber, secondNumber,
                    isMultiple(firstNumber, secondNumber));
        }
    }

    public static boolean isMultiple(int a, int b) {
        return (a % b == 0);
    }
} // end class