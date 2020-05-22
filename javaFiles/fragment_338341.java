import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static List<String> getAllMatches(String text, String regex) {
        List<String> matches = new ArrayList<String>();
        Matcher m = Pattern.compile("(?=(" + regex + "))").matcher(text);
        while(m.find()) {
            matches.add(m.group(1));
        }
        return matches;
    }

    public static void main(String[] args) {
        System.out.println(getAllMatches("abaca", "a.a"));
        System.out.println(getAllMatches("abaa", "a.*a"));
    }
}