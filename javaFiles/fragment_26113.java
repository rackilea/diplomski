import javax.swing.*;

public class Calculator {

public static void main(String args[]) {
    String numberOneString = JOptionPane.showInputDialog("Enter the first number: ");
    double numberOne = Double.parseDouble(numberOneString);
    String numberTwoString = JOptionPane.showInputDialog("Enter the second number: ");
    double numberTwo = Double.parseDouble(numberTwoString);
    String operation = JOptionPane.showInputDialog("Enter an operator (+.-.*,/,%): ");

    // Call performOperation method here        
    double result = performOperation(numberOne, numberTwo, operation);
    System.out.format("%.2f", numberOne);
    System.out.print(" " + operation + " ");
    System.out.format("%.2f", numberTwo);
    System.out.print(" = ");
    System.out.format("%.2f", result);

    System.exit(0);

} // End of main() method.
// Write performOperation method here.

public static double performOperation(double numberOne, double numberTwo, String operation) {
    double result = 0;

    switch (operation) {
        case "+":
            result = numberOne + numberTwo;
            break;
        case "-":
            result = numberOne - numberTwo;
            break;
        case "/":
            result = numberOne / numberTwo;
            break;
        case "*":
            result = numberOne * numberTwo;
            break;
        case "%":
            result = numberOne % numberTwo;
            break;
        default:
            break;
    }

    System.out.println("The result is " + result);
    return result;

}// END
} // End of Calculator class.