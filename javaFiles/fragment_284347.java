import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isValid=true;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') stack.push(currentChar);
            else if (currentChar == '}') {
                if (stack.isEmpty())isValid=false;
                else {
                    if (stack.pop() != '{') {
                        isValid=false;
                    }
                }
            } else if (currentChar == ')') {
                if (stack.isEmpty())isValid=false;
                else {
                    if (stack.pop() != '(') {
                        isValid=false;
                    }
                }
            } else if (currentChar == ']') {
                if (stack.isEmpty())isValid=false;
                else {
                    if (stack.pop() != '[') {
                        isValid=false;
                    }
                }
            }
        }
        return (isValid && stack.empty()?"YES":"NO");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}