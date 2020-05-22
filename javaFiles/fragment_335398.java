import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest
{
    private static final Pattern pat = Pattern.compile("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*");

    public static void main(String[] args) throws IOException
    {
        String data = "java.io.Serializable";
        Matcher m = pat.matcher(data);
        System.out.println(m.matches());
    }

}