import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]) throws Exception {
        String testString = "My name is someone like you, i am 22 years old, i was born in 19/10/1989,"
                          + " my phone number is  34544512 3454451266"
                          + " my brother is someone like me he is 18 years old, born in 9101993 "
                          + " his number is 07777666";

        String[] pieces = testString.split("\\s+");
        String expression = "\\d{8,}";
        Pattern pattern = Pattern.compile(expression);
        for (int i = 0; i < pieces.length; i++) {
            if (pattern.matches(expression, pieces[i]))
                System.out.println(pieces[i]);
        }
    }
}