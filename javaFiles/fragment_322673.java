import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MatcherTest {
    private static String text = "\"ab,\"\"c\"\",\"\"d\"\",\"\"e\"\",\"\"\"\"";

    private static String patternString = "\"{1,2}([^\",]*)(?:\"\")?(?:,|$)";

    public static void main(final String[] args) throws java.lang.Exception {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("'" + matcher.group(1) + "'");
        }
    }
}