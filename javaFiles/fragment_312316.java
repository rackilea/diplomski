import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class re{
    public static void main(String[] args){
        final String regex = "@[^@]*";
        final String string = "Check the @weather in new york and @order me a pizza";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }


    }
}