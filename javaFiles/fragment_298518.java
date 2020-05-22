import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Foo2 {
    public static void main(String[] args) {
        String line = "DBREF  1A1F A  102    190  UNP     P08046    EGR1_MOUSE      308     396";
        Pattern p = Pattern.compile("\\s+[a-zA-Z]\\s+\\d{1,}\\s+\\d{1,}\\s+");

        Matcher matcher = p.matcher(line);

        while (matcher.find()) {
            System.out.printf("group: %s%n", matcher.group());
        }
        System.out.println("done");
    }
}