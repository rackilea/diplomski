package com.stackoverflow.infix;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixPostfixEvaluator {

    private static final String operators = "-+/*";

    private int getPrecedence(String input) {
        char operator = input.charAt(0);
        int ret = 0;
        if (operator == '-' || operator == '+') {
            ret = 1;
        } else if (operator == '*' || operator == '/') {
            ret = 2;
        }
        return ret;
    }

    private boolean operatorGreaterOrEqual(String op1, String op2) {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    private boolean isOperator(String operator) {
        return operators.indexOf(operator) >= 0;
    }

    private boolean isOperand(String val) {
        try {
            Double.parseDouble(val);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Stack<String> convert2Postfix(List<String> expressionInTokens) {
        Stack<String> stack = new Stack<String>();
        Stack<String> postExpression = new Stack<String>();

        for (String c : expressionInTokens) {
            if (isOperator(c)) {
                while (!stack.isEmpty()) {
                    if (operatorGreaterOrEqual(stack.peek(), c)) {
                        postExpression.push(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(c);
            } else if (isOperand(c)) {
                postExpression.push(c);
            }
        }
        while(!stack.isEmpty()){
            postExpression.push(stack.pop());
        }
        Collections.reverse(postExpression);
        return postExpression;
    }

    public int evaluatePostfix(Stack<String> expression) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!expression.isEmpty()) {
            String c = expression.pop();
            if (isOperand(String.valueOf(c))) {
                stack.push(Integer.parseInt(c));
            } else if (isOperator(String.valueOf(c))) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                int result;
                switch (c) {
                case "*":
                    result = op1 * op2;
                    stack.push(result);
                    break;
                case "/":
                    result = op2 / op1;
                    stack.push(result);
                    break;
                case "+":
                    result = op1 + op2;
                    stack.push(result);
                    break;
                case "-":
                    result = op2 - op1;
                    stack.push(result);
                    break;
                }
            }
        }
        return stack.pop();
    }

    /**
     * Takes an expression and parses it, returning a list with every element of
     * the expression.The expression must not have white spaces, or characters
     * different from numbers or the operands + - / *
     * 
     */
    public List<String> split(String expression) {
        List<String> a = new LinkedList<String>();

        StringTokenizer st = new StringTokenizer(expression, "+*/-", true);
        while (st.hasMoreTokens())
            a.add(st.nextToken());
        return a;
    }

}