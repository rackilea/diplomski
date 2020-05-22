import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ONP {
        private static int precedence(String operator) {
            switch(operator) {
                case "(": return 0;
                case "+": case "-": return 1;
                case "*": case "/": return 2;
                case "^": return 3;
                case "sin": case "cos": return 4;
                default: return -1;
            }
        }

        private static List<String> tokenize(String input) {
            ArrayList<String> tokens = new ArrayList<>();
            Pattern p = Pattern.compile("\\(|\\)|[A-Za-z]+|\\d*\\.\\d*|\\d+|\\S+?");
            Matcher m = p.matcher(input);
            while(m.find()) {
              tokens.add(m.group());
            }
            return tokens;
        }

        private static List<String> toPostfix(List<String> infix) {
            Stack<String> st = new Stack<>();
            ArrayList<String> out = new ArrayList<>();
            for(String s: infix) {
                if(s.equals("(")){
                    st.push(s);
                } else if(s.equals(")")){
                    while(!st.empty() ){
                        String s2 = st.pop();
                        if(s2.equals("(")) break;
                        out.add(s2);
                    }
                } else if(precedence(s) > 0) {
                    int p = precedence(s);
                    while(!st.isEmpty() && precedence(st.peek()) >= p) out.add(st.pop());
                    st.push(s);
                } else {
                    out.add(s);
                }
            }
            while(!st.isEmpty()) out.add(st.pop());
            return out;
        }

        public static void main(String args[]) throws java.io.IOException, NumberFormatException ,EmptyStackException{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++){
                String input=br.readLine();
                List<String> tokens = tokenize(input);
                System.out.println("tokens: " + tokens);
                List<String> postfix = toPostfix(tokens);
                System.out.print("postfix: ");
                for(String s: postfix) System.out.print(s + " ");
                System.out.println();
            }
        }
}