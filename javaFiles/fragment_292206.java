import java.util.regex.*;
public class TEST {
    public static void main(String[] args) {
        String s = "A+B-(C/D)$(E+F)";
        Pattern regex = Pattern.compile(
            "# Verify that a string contains only specified characters.\n" +
            "^                # Anchor to start of string\n" +
            "[A-Z+\\-*/$()]+  # Match one or more valid characters\n" +
            "$                # Anchor to end of string\n",
            Pattern.COMMENTS);
        Matcher m = regex.matcher(s);
        if (m.find()) {
            System.out.print("OK: String has only valid characters.\n");
        } else {
            System.out.print("ERROR: String has invalid characters.\n");
        }
        // Verify the string contains only balanced parentheses.
        if (checkParens(s)) {
            System.out.print("OK: String has no unbalanced parentheses.\n");
        } else {
            System.out.print("ERROR: String has unbalanced parentheses.\n");
        }
    }
    // Function checks is string contains any unbalanced parentheses.
    public static Boolean checkParens(String s) {
        Pattern regex = Pattern.compile("\\(([^()]*)\\)");
        Matcher m = regex.matcher(s);
        // Loop removes matching nested parentheses from inside out.
        while (m.find()) {
            s = m.replaceFirst(m.group(1));
            m.reset(s);
        }
        regex = Pattern.compile("[()]");
        m = regex.matcher(s);
        // Check if there are any erroneous parentheses left over.
        if (m.find()) {
            return false;   // String has unbalanced parens.
        }
        return true;        // String has balanced parens.
    }
}