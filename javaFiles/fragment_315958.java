import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = ".*\\((?:\\s*(?:[^\\r\\n]*;)\\s*)+\\);|[^\\r\\n]+";
        final String string = "string 1;\n"
             + "string 2;\n"
             + "string 3;\n"
             + "string 4 (\n"
             + "   substring 1;\n"
             + "   substring 2;\n"
             + "   substring 3;\n"
             + ");\n"
             + "string 4;\n"
             + "string 1;\n"
             + "string 2;\n"
             + "string 3;\n"
             + "string 4 (\n"
             + "   substring 1;\n"
             + "   substring 2;\n"
             + "   substring 3;\n"
             + ");\n"
             + "string 4;";

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