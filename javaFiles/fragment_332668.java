import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) 
    {
        Pattern p = Pattern.compile("https://secure\\.runescape\\.com/m=displaynames/.*/check_name\\.ws\\?displayname=(\\?)?");
        Matcher m = p.matcher("callback_request(\"https://secure.runescape.com/m=displaynames/s=p2FAuYaMFDgzntbDei*324JUo*3ozJ7hR*h1KNlxc6kPaBeKCBrdKH5kzljYSfUa/check_name.ws?displayname=\" + escape(text), handleResult);");
        if(m.find())
        {
            System.out.println(m.group(0));
        }
    }
}