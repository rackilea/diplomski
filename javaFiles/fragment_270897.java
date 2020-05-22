import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegEx {
    public static void main(String[] args) {
        String s = "<a href=\"/wiki/Computer_scientist\" title=\"Computer scientist\">computer scientist</a> <p>Its fields can be divided into a variety of theoretical and <a href=\"/wiki/Practical_disciplines\"";
        String r = "<p>.*?href=\"(.*?)\"";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}