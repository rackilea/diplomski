import java.util.Scanner;

 public class Assignment3 {

public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to the Calculator!");
    System.out.println("Enter the first operand:");
    double firstOperand = scan.nextDouble();
    System.out.println("Enter the second operand:");
    double secondOperand = scan.nextDouble();
    System.out.println("Operations are:");
    System.out.println("ADD or  + for addition");
    System.out.println("SUBTRACT or - for subraction");
    System.out.println("MULTIPLY or * for multiplication");
    System.out.println("DIVIDE or / for division");
    System.out.println("Enter your selection:");
    String selection = scan.next();
    double ADD = (firstOperand + secondOperand);
    double SUBTRACT = (firstOperand - secondOperand);
    double MULTIPLY = (firstOperand * secondOperand);
    double DIVIDE = (firstOperand / secondOperand);

    if (selection.equals("+")) {
        System.out.println("The product is:" + ADD);
    }
    else if (selection.equals("-")) {
        System.out.println("The product is:" + SUBTRACT);
    }
    else if (selection.equals("*")) {
        System.out.println("The product is:" + MULTIPLY);
    }
    else if (selection.equals("/")) {
        System.out.println("The product is:" + DIVIDE);
    }
}
}