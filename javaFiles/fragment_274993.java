import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String s = "Today [#[#item#] was|the items were#] shipped so [#it is|they are#] gone.";
        System.out.println(convert(s, true));
        System.out.println(convert(s, false));
    }

    public static String convert(String text, boolean isSingular) {
        Pattern spPattern = Pattern.compile("\\[#((?:\\[#.*?#]|(?!#])[^|])*?)\\|((?:\\[#.*?#]|(?!#])[^|])*?)#]");
        Matcher matcher = spPattern.matcher(text);
        while (matcher.find()) {
            String replacement = isSingular ? matcher.group(1) : matcher.group(2);
            text = matcher.replaceFirst(replacement);
            matcher = spPattern.matcher(text);
        }
        return text;
    }
}