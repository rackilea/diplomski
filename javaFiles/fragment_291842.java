package so_6806699;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author martijn
 */
public class NameMatcher
{

    private String input;
    public static final String REGEX = "m_[a-z]+([A-Z0-9_\\$\\µ\\£]*)";
    public static final Pattern PATTERN = Pattern.compile(REGEX);

    public NameMatcher(String input)
    {
        this.input = input;
    }

    public String performReplacements()
    {
        Matcher m = PATTERN.matcher(input);
        StringBuilder sb = new StringBuilder();

        int oldEnd = 0;
        while (m.find())
        {
            int start = m.start();
            int end = m.end();

            String match = input.substring(start, end);
            String matchGroup1 = match.replaceAll(REGEX, "$1");
            if (!matchGroup1.isEmpty())
            {
                char[] match_array = matchGroup1.toCharArray();
                match_array[0] = Character.toLowerCase(match_array[0]);
                match = new String(match_array);
            }

            sb.append(input.substring(oldEnd, start));
            oldEnd = end;

            sb.append(match);
        }
        sb.append(input.substring(oldEnd));
        return sb.toString();
    }
}