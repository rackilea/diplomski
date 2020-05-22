import java.util.Stack;
import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a Number:");
        int numb = sc.nextInt();

        while (numb != 0) {
            int bin = numb % 2;
            s.push(bin);
            numb /= 2;
        }

        Stack<Integer> st = (Stack<Integer>) s.clone(); // Added this line

        System.out.println("Binary:");
        while (!(s.isEmpty())) {
            System.out.print(s.pop());
        }
        System.out.println();

        System.out.println("Octal: "
                + changeBase((Stack<Integer>) st.clone(), 8)); // Added this line
        System.out.println("Hexadecimal: "
                + changeBase((Stack<Integer>) st.clone(), 16)); // Added this line
    }

    public static String changeBase(Stack<Integer> st, int base) {
        StringBuilder result = new StringBuilder();
        int length = st.size();

        int bitsPerDecimal = 0, base_copy = base;
        while (base_copy > 1) {
            base_copy /= 2;
            ++bitsPerDecimal;
        }

        int padding = bitsPerDecimal - (length % bitsPerDecimal); // make size of stack multiple  of bitsPerDecimal
        for (int i = 0; i < padding; ++i) {
            st.push(0);
        }

        while (!st.empty()) {
            int no = 0, pow = base;
            for (int i = 0; i < bitsPerDecimal; ++i) { // Get the required bits to make a digit
                pow /= 2;
                no = no + pow * st.pop();
            }
            if (no > 9)
                result.append((char) ('A' + (no - 10)));
            else
                result.append(Integer.toString(no));
        }
        return result.toString();
    }
}