import java.util.Scanner;

class recursiveParsingCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Ask user to input the expression
        System.out.println("Please input the expression");
        String userInput = scanner.nextLine();
        System.out.println(
                "And the final result is: " + recursiveCalculation(userInput, userInput.length() - 1, 0, 0, 0));
        scanner.close();
        System.exit(0);
    }

    // Identify the type of character at a specific position
    public static char charOfString(String userInput, int i) {
        return userInput.charAt(i);
    }

    /*
     * Position must be userInput.length() - 1 initially. currentResults, operand1
     * and operand2 are also meant to be initilized with 0.
     */
    public static int recursiveCalculation(String userInput, int position, int operand1, int operand2,
            int currentResults) {
        // If position is zero, just output the operand.
        if (position == 0) {
            if (Character.isDigit(charOfString(userInput, position))) {
                return charOfString(userInput, position) - '0';
            } else {
                System.out.println("Invalid input.");
            }
        }
        if (position > -1) {
            // Check if it is a number or an operator
            if (Character.isDigit(charOfString(userInput, position))) {
                operand1 = charOfString(userInput, position) - '0'; // First operand

                // Check if 2nd char is a number or an operator.
                if (Character.isDigit(charOfString(userInput, position - 1))) {
                    operand2 = charOfString(userInput, position - 1) - '0';
                    position = position - 1;
                }
            } else {
                // If it is an operator, then proceed to compute the results so far
                char operator = charOfString(userInput, position);

                // If it is a binary situation
                if (operator == '+' || operator == '*') {
                    currentResults = binaryOperator(operator, operand1, operand2);
                    operand2 = currentResults;
                }
                // If it is an unary situation
                else if (operator == '!') {
                    if (currentResults == 0) {
                        currentResults = operand1;
                    }
                    currentResults = unaryOperator(currentResults);
                    operand2 = currentResults;
                } else {
                    System.out.println("Invalid operator");
                    return 0; // Return zero by default
                }
            }
            position = position - 1;
        }
        if (position > -1) {
            return recursiveCalculation(userInput, position, operand1, operand2, currentResults);
        } else {
            return currentResults;
        }
    }

    public static int binaryOperator(char operator, int operand1, int operand2) {
        switch (operator) {
        case '+':
            return operand1 + operand2;
        case '*':
            return operand1 * operand2;
        default:
            System.out.println("Invalid binary Operator");
            return 0; // Return zero by default
        }
    }

    // Calculate the factorial
    public static int unaryOperator(int operand) {
        if (operand <= 1)
            return 1;
        else
            return operand * unaryOperator(operand - 1);
    }
}