import java.util.regex.Pattern;
import java.util.regex.Matcher;

Pattern pattern = Pattern.compile("(?<=<pre>)(.*?)(?=</pre>)");
Matcher m = pattern.matcher(string);
StringBuffer replacement = new StringBuffer();

while (matcher.find())
{
     matcher.appendReplacement(replacement, "");
     // Careful using unknown text in appendReplacement as any "$n" will cause problems
     replacement.append(matcher.group(1).replace("a", "b"));
}    
matcher.appendTail(replacement);
String result = replacement.toString();