import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpression{

    public static void main(String[] args){

        final String regex = "(?<=[0-9])(?=[a-z])|(?<=[a-z])(?=[0-9])";
        final String string = "number1number1number1";
        final String subst = " ";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        final String result = matcher.replaceAll(subst);

        System.out.println(result);

    }
}