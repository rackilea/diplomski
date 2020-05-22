import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        System.out.println("Please enter your calculation");
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        String op = scanner.next();
        int right = scanner.nextInt();
        System.out.println(compute(left, op, right));
    }

    private static int compute(int left, String op, int right) {
        switch (op.charAt(0)) {
        case '+':
            return left + right;
        case '-':
            return left - right;
        case '*':
            return left * right;
        case '/':
            return left / right;
        }
        throw new IllegalArgumentException("Unknown operator:" + op);
    }
}