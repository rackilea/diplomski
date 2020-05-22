import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) 
    {
        Pattern p = Pattern.compile("https://secure\\.runescape\\.com/m=displaynames/.*/check_name\\.ws\\?displayname=\\?");
        System.out.println(p.matcher("https://secure.runescape.com/m=displaynames/s=bOVZmsrjbNQzntbDei*324JUo*3ozJ7hR*h1KNlxc6kPaBeKCBrdKIxD*edhi4qH/check_name.ws?displayname=?").find());
    }
}