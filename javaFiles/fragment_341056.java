import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitRegex {

    public static void main(String[] args) {
        // The search string
        String str = "[str1 str2] (str3 str4) hello world";

        // The Regular expression (Finds [(word)] tokens)
        Pattern pt = Pattern.compile("[\\(\\[]([^\\]\\)]*)[\\]\\)]");

        // Match the string with the pattern
        Matcher m = pt.matcher(str);

        // If results are found
        while (m.find()) {
            System.out.println(m.group(0)); 
        }
    }

}