import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String expression = "String contains @[alph4Num3ric-alph4Num3ric] as substring";

        Pattern pattern = Pattern
                .compile("\\@\\[([a-zA-Z0-9]+)-([a-zA-Z0-9]+)\\]");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            System.out.println("matched: "+matcher.group());
            System.out.println("group1: "+matcher.group(1));
            System.out.println("group2: "+matcher.group(2));
            System.out
                    .println("after replace "+expression.replace(matcher.group(1), "customkey"));
        }
    }

}