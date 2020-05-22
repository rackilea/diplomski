import java.util.Scanner;

public class calling {

    private Scanner scanner = null;

    private int getInt(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public calling() {
        scanner = new Scanner(System.in)
        int x = getInt("Please enter a number: ");
        int y = getInt("Please enter a second number: ");
        System.out.println("The sum of the two numbers is: " + (x + y));
    }

    public static void main(String[] args) {
        new calling();
    }
}