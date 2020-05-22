import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test
{
    public static void main(String[] args) {
        String[] tests = {
            "FF:",
            "FF:AA:",
            ":FF",
            ":AA:FF",
            ":AA:BB:CC:DD:FF",
            "AA:BB:CC:DD:EE:FF",
            "FF",
            "FF:AA",
            ":FF:",
            ":OO:JJ",
            ":AA:BB:CC:DD:EE:FF",
        };
        Pattern pattern = Pattern.compile("^(?=(:|.*:$|.{17}$))(?=.{3,17}$)(?!.{4}$):?[0-9A-F]{2}(:[0-9A-F]{2})*:?$");
        for (String test : tests) {
            Matcher matcher = pattern.matcher(test);
            System.out.println(test + " " + (matcher.matches() ? "match" : "no match"));
        }
    }
}