import java.util.regex.*;

public class Test {
    public static void main(String[] args) {

        // Create a regular expression pattern
        Pattern spec = Pattern.compile("\\((.*?)=(.*?)\\)");

        // Get a matcher for the searchFilter
        String searchFilter = "(first=sam*)(last=joy*)";
        Matcher m = spec.matcher(searchFilter);

        // While a "abc=xyz" pattern can be found...
        while (m.find())
            // ...print "abc" equals "xyz"
            System.out.println("\""+m.group(1)+"\" equals \""+m.group(2)+"\"");
    }
}