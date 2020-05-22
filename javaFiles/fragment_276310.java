import java.util.regex.Matcher;
import java.util.regex.Pattern;

String text = editText.getText().toString();
String regexPattern = "(#\\w+)";

Pattern p = Pattern.compile(regexPattern);
Matcher m = p.matcher(text);
while (m.find()) {
    String hashtag = m.group(1);
    // Add hashtag to ArrayList
    ...
}