import java.util.*;

import javax.swing.JOptionPane;

public class Calc {

    public String infix(String expression)
    {
        expression=expression.replaceAll("[\t\n ]", "");
        String operator = "(*/+-)"; // I added (,) see line 20 for why ...
        int value1, value2;
        char ch;
        StringTokenizer tokenizer = new StringTokenizer(expression, operator, true); 
        Stack<Integer> valueStack = new Stack<Integer>();
        Stack<Character> operatorStack = new Stack<Character>();

        while(tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            // the token here was "(5" when really it should be 5, therefore 5 doesn't get put on the value stack, which has consequences
            // see line 37 ...
            if(isInteger(token) == true)
                valueStack.push(Integer.parseInt(token));
            else if(token.charAt(0) == '(')
                operatorStack.push(token.charAt(0));
            else if(token.charAt(0) == ')')
                while(operatorStack.peek() != '(') // also need to check if the stack is empty here ...
                {
                    value1 = valueStack.pop();
                    value2 = valueStack.pop();
                    valueStack.push(solver(value1, value2, operatorStack.pop()));
                    operatorStack.pop();
                    // also need to check if the stack is empty here ...
                    if (operatorStack.isEmpty())
                        break;
                }
            else if(token.charAt(0) == '+' || token.charAt(0) == '-' || token.charAt(0) == '*' || token.charAt(0) == '/')
            {
                while(!operatorStack.isEmpty() && precedence(token.charAt(0)) <= precedence(operatorStack.peek()))
                {   // the bug happens because there is only one value [3] on the valueStack, and here you assume there are 2 (should be 3,5)
                    value1 = valueStack.pop(); 
                    value2 = valueStack.pop(); //empty stack error starts here
                    valueStack.push(solver(value1, value2, operatorStack.pop()));
                }
                operatorStack.push(token.charAt(0));
            }
        }
        while(!operatorStack.isEmpty())
        {
            value1 = valueStack.pop();
            value2 = valueStack.pop();
            ch = operatorStack.pop();
            valueStack.push(solver(value1, value2, ch));
        }


        String result = Integer.toString(valueStack.pop());
        return result;     
    }  //End of infix

    public static boolean isInteger(String s)
    {
        try
        { 
            Integer.parseInt(s);
        } 
        catch(NumberFormatException e)
        {
            return false; 
        } 
        catch(NullPointerException e) 
        {
            return false;
        }
        return true;
    } // end of isInteger

    public int solver( int value1, int value2, char operator)
    {
        try
        {
            if(operator == '*')
                return value2 * value1;
            else if(operator == '/')
                return value2 / value1;
            else if(operator == '+')
                return value2 + value1;
            else if(operator == '-')
                return value2 - value1;
            else
                return 0;
        }
        catch(ArithmeticException e )
        {
            JOptionPane.showMessageDialog(null, "Division by Zero");
        }
        return 0;
    } // end of solver

    public int precedence(char op)
    {
        if(op == '+' || op == '-')
            return 1;
        else if(op == '*' || op == '/')
            return 2;
        else
            return 0;
    }   // end of precedence


    public static void main (String [] args) {
        Calc c = new Calc();

        System.out.println(c.infix("(5+2-1)")); // heyy it works now :)
    }

}