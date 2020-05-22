import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
    public static void main(String []args){
        String sentence = "Most implementations<img title=\"hello:\" alt=\"hello:{}\" src=\"http://images.doctissimo.fr/hello.gif\" class=\"wysiwyg_smiley\" /> provide ASDF as a module, and you can simply (require \"asdf\").";
        String RegEx = "(?is)(\\w+|[\u00E0\u00C0\u00E2\u00C2\u00E4\u00C4\u00E1\u00C1\u00E9\u00C9\u00E8\u00C8\u00EA\u00CA\u00EB\u00CB\u00EC\u00CC\u00EE\u00CE\u00EF\u00CF\u00F2\u00D2\u00F4\u00D4\u00F6\u00D6\u00F9\u00D9\u00FB\u00DB\u00FC\u00DC\u00E7\u00C7\u2019\u00F1]+)(<[^>]+>)?";

        Pattern mypattern = Pattern.compile(RegEx);

        Matcher myMatcher = mypattern.matcher(sentence);
        String output=myMatcher.replaceAll("<font color=\"white\">$1</font>$2");

        System.out.println(output);
     }
}