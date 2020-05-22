import java.util.Scanner;

public class oddoreven {
    public static void main(String[] args) {
        int num;
        int x = 1;
        while (x == 1) {
            System.out.println("Enter a number to check whether or not it is odd or even");
            Scanner s = new Scanner(System.in);

            boolean isInt = s.hasNextInt(); // Check if input is int
            while (isInt == false) { // If it is not int
                s.nextLine(); // Discarding the line with wrong input
                System.out.print("Please Enter correct input: "); // Asking user again
                isInt = s.hasNextInt(); // If this is true it exits the loop otherwise it loops again
            }
            num = s.nextInt(); // If it is int. It reads the input

            if (num % 2 == 0)
                System.out.println("The number is even");
            else
                System.out.println("The number is odd");
            // trying to figure out how to get the code to terminate if you put in a value
            // that isn't a number
            System.out.println("Type 1 to continue, 0 to terminate");
            x = s.nextInt();
        }

    }
}