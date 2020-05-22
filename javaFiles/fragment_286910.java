import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class re{

    public static void main(String[] args){

        final String regex = "(?i)(.*?)\\s+student\\s+([^,\\r\\n]*),([^=\\r\\n]*)=([0-9.]*),([^=\\r\\n]*)=([0-9.]*)";
        final String string = "Some Name student Pass,Maths=10,Science=9 Kishan student Pass,Maths=10,Science=9.1 Some Other Name Student Pass,Maths=10,Science=9 Kishan student Pass,Maths=10,Science=9.3";

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