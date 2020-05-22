import java.util.regex.*;

public class Test {

    public static void main(String[] args) {
        String input = "main.c:11: error: 'qz' undeclared (first use in this function)";

        Pattern p = Pattern.compile("([^:]+\\.c):(\\d+):(.*)");
        Matcher m = p.matcher(input);

        if (m.matches()) {
            System.out.println("File: " + m.group(1));
            System.out.println("Line: " + m.group(2));
            System.out.println("Message: " + m.group(3));
        }
    }
}