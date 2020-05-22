import java.util.*;

public class PrefixEvaluator {
    public static void main(String[] args) {
        String input = "- * + 4 3 2 5";
        String[] expression = input.split ( " " );

        Queue<String> expressionQueue = new LinkedList<String>();

        for (String element : expression)
        {
            expressionQueue.add ( element );
        }

        System.out.println("value = " + evaluate(expressionQueue));
    }

    // pre : input contains a legal prefix expression
    // post: expression is consumed and the result is returned
    public static double evaluate(Queue <String> input) {
        if(input.peek ( ) != null && input.peek ( ).matches ( "^(-?)\\d+$" ))
        {
            return Long.parseLong ( input.poll ( ) );
        }
        else 
        {
            String operator = input.poll();
            double operand1 = evaluate(input);
            double operand2 = evaluate(input);
            return evaluate(operator, operand1, operand2);
        }
    }

    // pre : operator is one of +, -, *, / or %
    // post: returns the result of applying the given operator to
    //       the given operands
    public static double evaluate(String operator, double operand1,
                                  double operand2) {
        if (operator.equals("+")) {
            return operand1 + operand2;
        } else if (operator.equals("-")) {
            return operand1 - operand2;
        } else if (operator.equals("*")) {
            return operand1 * operand2;
        } else if (operator.equals("/")) {
            return operand1 / operand2;
        } else if (operator.equals("%")) {
            return operand1 % operand2;
        } else {
            throw new RuntimeException("illegal operator " + operator);
        }
    }
}