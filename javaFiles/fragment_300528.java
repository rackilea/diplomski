import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class testCode
{
    public static void main(String args[])
    {
        String text = "John writes about this, and John writes about that";
        String patternString1 = "(John)([^,]*)";

        Pattern pattern = Pattern.compile(patternString1);
        Matcher regexMatcher = pattern.matcher(text);

        List<String> returnValue= new ArrayList<String>();

        while(regexMatcher.find())
            if(regexMatcher.group().length() != 0)
                returnValue.add(regexMatcher.group());

        for(int i=0; i<returnValue.size(); i++)
            System.out.println(returnValue.get(i));
    }
}