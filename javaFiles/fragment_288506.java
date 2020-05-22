import java.util.regex.*;

class Test
{
    public static void main(String[] args)
    {
        String pat = "^\\[([\\w]+) \\[([\\w]+)\\] -> \\w+\\] (.*)$";
        Pattern rx = Pattern.compile(pat);
        String text = "[Username [rank] -> me] message";
        Matcher m = rx.matcher(text);
        if(m.find())
        {
            System.out.println("Match found:");
            for(int i=0; i<=m.groupCount(); i++)
            {
                System.out.println("  Group " + i + ": " + m.group(i));
            }
        }
    }
}