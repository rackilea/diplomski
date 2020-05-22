import java.util.regex.Matcher;
import java.util.regex.Pattern;

...

Matcher matcher = Pattern.compile("(US\\d+)").matcher(str1);
if (matcher.find()) {// if it matched the pattern
    String result = matcher.group(0);// the group captured by the regex
}