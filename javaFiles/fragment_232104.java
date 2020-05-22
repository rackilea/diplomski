import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String input = "The big black dog big black dog is a friendly friendly dog who lives nearby nearby.";

        Pattern dupPattern = Pattern.compile("([ \\w]+)\\1", Pattern.CASE_INSENSITIVE);
        Matcher matcher = dupPattern.matcher(input);

        while (matcher.find()) {
            input = input.replaceAll("([ \\w]+)\\1", "$1");
        }
        System.out.println(input);

    }
}