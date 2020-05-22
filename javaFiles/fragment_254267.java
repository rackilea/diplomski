import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Test
{
public static void main(final String[] args)
{
    final Pattern pattern = Pattern.compile("f(\\w+)");
    final Matcher matcher = pattern.matcher("fb=1");
    while (matcher.find())
    {
        System.out.println(matcher.group());
    }
}
}