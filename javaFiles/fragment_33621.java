import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        final String regex = "\\d+(\\.?\\d+)?(\\+|\\-|sd)?(\\d+(\\.?\\d+)?)?[ ]*%";
        final String test_str = "\"Titi 10% Toto and tutu equals 20X\"\n"
                + "\"Titi 10.50% Toto and tutu equals 20X\"\n"
                + "\"Titi 10-10.50% Toto and tutu equals 20X\n"
                + "\"Titi 10sd50 % Toto and tutu equals 20X\n"
                + "\"Titi 10-10.50% or 10sd50 % Toto and tutu equals 20X";

        final Pattern pattern = Pattern.compile(regex);
        for(String data : test_str.split("\\r?\\n")) {
            Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                System.out.print(data.substring(matcher.start(), matcher.end()-1) + " ") ;
            }
            System.out.println();
        }
    }
}