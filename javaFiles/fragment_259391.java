import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexTester {
    public static void main(String[] arguments) {
        String userInputPattern = arguments[0];
        try {
            Pattern.compile(userInputPattern);
        } catch (PatternSyntaxException exception) {
            System.err.println(exception.getDescription());
            System.exit(1);
        }
        System.out.println("Syntax is ok.");
    }
}