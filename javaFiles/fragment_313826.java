import java.util.Scanner;

public class calling {

    public calling() {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Please enter a number: ");
        int x = scanner.nextInt();

        System.out.print("Please enter a second number: ");
        int y = scanner.nextInt();

        System.out.println("The sum of the two numbers is: " + (x + y));
    }

    public static void main(String[] args) {
        new calling();
    }
}