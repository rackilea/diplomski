import java.util.regex.*;

class TestRegex
{
    public static void main(String[] args)
    {
        Pattern p = Pattern.compile("al");
        Matcher m = p.matcher("albala");
        while(m.find())
            System.out.println(m.start());
    }
}