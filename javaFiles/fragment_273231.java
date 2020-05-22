import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string_1 = s.next();
        String string_2 = s.next();
        System.out.println("a) Determine the length of string_1: " + 
string_1.length() + "/t b) Determine the length of " +
            "string_2: " + string_2.length() + "/tc) Concatenate both 
strings: " + string_1.concat(string_2) + "/td) " +
            "Check if the two strings have same set of characters 
with regard to case: ");
    if (string_1.equalsIgnoreCase(string_2)) {
        System.out.print("equal.");`enter code here`
    }
    if ((string_1.compareToIgnoreCase(string_2) > 0) || 
(string_1.compareToIgnoreCase(string_2) < 0)) {
        System.out.print("They are not equal.");
    }
        System.out.println("e) Convert string_1 to upper case: " + 
string_1.toUpperCase() + "/tf) Convert string_2 to " +
            "lower case: " + string_2.toLowerCase() + "/tg) Extract a 
valid sub-string of multiple characters from string_1: " +
            string_1.substring(0, string_1.length()));
    }
}