import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regextest {

    static String[] matchThese = new String[] {
            "sdfads saf as fa http://www.google.com some more text",
            "sdfads fa http://www.dupa.com some more text",
            "should not match http://" };

    public static void main(String[] args) {

        String regex = "(https?://|www)\\S+";
        Pattern p = Pattern.compile(regex);

        System.out.println("Those that match are replaced:");
        for (String input : matchThese) {
            if (p.matcher(input).find()) {

                Matcher matcher = p.matcher(input);
                matcher.find();

                // Retrieve matching string
                String match = matcher.group();

                String output = input.replace(input, match);
                System.out.println(output);

            }
        }

    }
}