import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([\\w\\s]+) word");
        Matcher m = p.matcher("Could you test a phrase with some word");
        while (m.find()) {
            System.err.println(m.group(1));
            System.err.println(m.group());
        }
    }
}