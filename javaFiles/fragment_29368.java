import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunIt {

    public static void main(String[] args) throws URISyntaxException {
        Pattern p = Pattern.compile(".*?([^.]+\\.[^.]+)");

        String[] urls = new String[] {
                "https://foo.com/bar",
                "http://www.foo.com#bar",
                "http://bar.foo.com"
        };

        for (String url:urls) {
            URI uri = new URI(url);
            //eg: uri.getHost() will return "www.foo.com"
            Matcher m = p.matcher(uri.getHost());
            if (m.matches()) {
                System.out.println(m.group(1));
            }
        }
    }
}