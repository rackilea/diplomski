import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class re{

    public static void main(String[] args){

        final String regex = "(?i)^\\*[a-z0-9]+_[a-z0-9]+\\*$";
        final String string = "*test_text*\n"
             + "*test____text*\n"
             + "*test_*[text*\n"
             + "*test_again_tex";

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