import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UTF8 {
    public static void main(String[] args) {
        String utf8tweet = "";
        try {
            byte[] utf8Bytes = "#Hello twitter  How are you?".getBytes("UTF-8");

            utf8tweet = new String(utf8Bytes, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Pattern unicodeOutliers = Pattern.compile("[^\\x00-\\x7F]",
                Pattern.UNICODE_CASE | Pattern.CANON_EQ
                        | Pattern.CASE_INSENSITIVE);
        Matcher unicodeOutlierMatcher = unicodeOutliers.matcher(utf8tweet);

        System.out.println("Before: " + utf8tweet);
        utf8tweet = unicodeOutlierMatcher.replaceAll(" ");
        System.out.println("After: " + utf8tweet);
    }
}