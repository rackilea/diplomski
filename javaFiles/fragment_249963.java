import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class re{
    public static void main(String[] args){

        final String regex = "^(\\D+)([0-9]{4,})(9[0-9]{3})([A-Z]{2})$|^(\\D+)([0-9]{4,})([0-9]{5})([A-Z]{2})$";
        final String string = "CompanyUIP198710800ST\n"
             + "CompanyA1982210800ST\n"
             + "CompanyVT191039405YT\n"
             + "CompanyBX1910249405YT";

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