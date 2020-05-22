import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        int num1, num2, result;

        System.out.println("What Do You Want to Do? (a to add; s to"
                + " subrtact; d to divited; m to multiply, and s to square your nummber.)");

        String choice = user_input.next();

        // Add
        if (Character.isLetter('a')) {
            System.out.println("Enter first number: ");
            num1 = user_input.nextInt();
            System.out.println("Enter second number: ");
            num2 = user_input.nextInt();

            result = num1 + num2;
            System.out.println("Answer: " + result);
        }
    }
}