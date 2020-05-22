import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

    public static void main(String[] args) {
        String regex = "(https?://[\\S^\"]+(?<!\\.ico|\\.jpg|\\.css))[\\s\"]";

        String test_string = "http://www.regular-   expressions.info/shorthand.html "
                + "http://www.regular-expressions.info/shorthand.html "
                + "http://www.regular-expressions.info/shorthand.css "                          
                + "http://www.regular-expressions.info/shorthand.ico "
                + "http://www.regular-expressions.info/shorthand.jpg "
                + "http://www.regular-expressions.info/shorthand.htm "
                + "http://www.regular-expressions.info/shorthand.jsp "
                + "http://www.regular-expressions.info/ ";


        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(test_string);
        while (m.find()) {
            System.out.printf("Match: '%s'\n",  m.group(1));
        }
    }

}