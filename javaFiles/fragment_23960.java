import java.util.regex.*;
Pattern p = Pattern.compile("(.*) on (.*)");
Matcher m = p.matches(input);
if( m.matches() ) {
    String username = m.group(1);
    String date = m.group(2);
} else {
    throw new Exception("Did not match expected pattern");
}