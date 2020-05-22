import java.util.regex.Matcher;
import java.util.regex.Pattern;

public String matchID(String data) {
    Pattern r = new Pattern("(france\\d+Id)=([a-zA-Z0-9]+),");
    Matcher m = r.matcher(data);
    return m.group(2);
}