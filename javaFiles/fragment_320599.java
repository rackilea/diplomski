import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "^021(\\d)\\1\\d{6}$";
        final String string = "02177890488\n"
             + "02177098765\n"
             + "02199123450\n"
             + "02100890488\n"
             + "02111098765\n"
             + "02122123450\n"
             + "02133123450\n"
             + "02144123450\n"
             + "02155123450\n"
             + "02166123450\n"
             + "02188123450";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }

    }
}