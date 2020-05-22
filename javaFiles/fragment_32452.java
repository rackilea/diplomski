import java.util.regex.*;

public class Example
{
    public static void main(String[] args)
    {
        System.out.println("Matches: " + "abc".matches("a+"));

        Matcher matcher = Pattern.compile("a+").matcher("abc");
        System.out.println("Find: " + matcher.find());
    }
}