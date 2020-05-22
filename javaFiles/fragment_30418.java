import java.util.regex.*;

public class Foo {
    public static void main(String[] args) {
        // NOTE: I've also tested passing the regex as an arg from the command
        // line
        // as "n.w\s+h(a|i)s"
        String regex = "n.w\\s+h(a|i)s";
        String input = "Java now has regular expressions";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);

        // Starting at the beginning of the input string, look for a match in
        // ANY
        // region of the input string
        boolean matchFound = m.find();
        System.out.println("Match was found: " + matchFound);
        System.out.println("Matched string is: " + m.group());
    }
}