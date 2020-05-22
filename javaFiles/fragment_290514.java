import java.util.*;

public class Task16 {
    public static void main(String[] args) {


        System.out.println("Infix Expression     Postfix Expression");
        System.out.println("  (10 + 5) * 8            " + infixToPostfix("(10 + 5) * 8 "));
        System.out.println("   10 * (5 + 8)           " + infixToPostfix("10 * (5 + 8)"));
    }

    /** Method converts an infix expression into a postfix expression */
    public static String infixToPostfix(String expression) {

        LinkedList<String> operatorList = new LinkedList<>();


        LinkedList<String> resultList = new LinkedList<>();


        Stack<Character> stack = new Stack<>();


        expression = insertBlanks(expression);


        String[] tokens = expression.split(" ");


        for (String token: tokens) {
            if (token.length() == 0) 
                continue; // 
            else if (token.charAt(0) == '(') 
                stack.push(token.charAt(0));
            else if (!stack.isEmpty() && stack.peek() == '(' && 
                        token.charAt(0) != ')') {

                if (Character.isDigit(token.charAt(0)))
                    resultList.addLast(token);
                else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||
                            token.charAt(0) == '*' || token.charAt(0) == '/' )
                    operatorList.addFirst(token);
            } 
            else if (!stack.isEmpty() && token.charAt(0) == ')') {

                resultList.addAll(operatorList);
                operatorList.clear();
                stack.pop();
            }
            else if (token.charAt(0) == '+' || token.charAt(0) == '-')
                operatorList.addLast(token); 
            else if (token.charAt(0) == '*' || token.charAt(0) == '/') 
                operatorList.addFirst(token); 
            else if (Character.isDigit(token.charAt(0)))
                resultList.addLast(token); 
        }


        String result = "";
        resultList.addAll(operatorList);
        for (String e: resultList) {
            result += e + " ";
        }


        return result;
    }


    public static String insertBlanks(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')' ||
                 s.charAt(i) == '+' || s.charAt(i) == '-' ||
                 s.charAt(i) == '*' || s.charAt(i) == '/')
                result += " " + s.charAt(i) + " ";
            else
                result += s.charAt(i);
        }

        return result;
    }
}


import java.util.Stack;

public class Task14 {
     static int Prec(char ch)
     //this method will return return preference according to the operator
        {
        switch (ch){

        case '+':
        case '-':
        return 1;

        case '*':
        case '/':
        return 2;

        case '^':
        return 3;
        }
        return -1;
        }

     static String infixToPostfixConversion(String expression){

        String result ="";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<expression.length(); ++i){
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Invalid Expression";
                else
                    stack.pop();
                }
            else
            {
            while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek()))
                result += stack.pop();
            stack.push(c);
            }

        }
        while (!stack.isEmpty())
            result += stack.pop();
        return result;
        }

        public static void main(String[] args){
            String exp = args[0];//expression equals line argument 
            String result = infixToPostfixConversion(exp); //the result will equal the function of that expression "changing from infix to post"

            System.out.println("Conversion of infix " + exp + " Postfix is " + result);
        }

        }

import java.util.*;
import java.io.*;

public class Task1 {
    private static Scanner in;

    public static void main (String[] args) throws Exception {
        // 

        if (args.length != 1) {
            System.out.println("Usage: TextFile");
            System.exit(0);

        }
String filename = args[0];


TreeSet<String> treeSet = new TreeSet<String>(Collections.reverseOrder());
try
{
    in = new Scanner(new File(filename));
    String line;
    while ((line = in.nextLine())!=null)
    {
        String[] tokens = line.split("[|\n|\t|\r|.|,|)|(|-|\"]");



        for (int i = 0; i  < tokens.length; i++)

            treeSet.add(tokens[i]);

    }
}
catch (Exception ex){

}
System.out.println("\nDisplay words in descending order");

Iterator<String> iterator = treeSet.iterator();
while (iterator.hasNext()) {
System.out.println(iterator.next());
}
}
}