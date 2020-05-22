package grimbo.url;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) {
        // context1
        URL c1 = u(null, "http://www.example.com/page.html");
        u(c1, "http://www.example.com/page.html");
        u(c1, "/page.html");
        u(c1, "page.html");
        u(c1, "../page.html");
        u(c1, "#paragraphA");

        System.out.println();

        // context2
        URL c2 = u(null, "http://www.example.com/path/to/page.html");
        u(c2, "http://www.example.com/page.html");
        u(c2, "/page.html");
        u(c2, "page.html");
        u(c2, "../page.html");
        u(c2, "#paragraphA");
    }

    public static URL u(URL context, String url) {
        try {
            URL u = null != context ? new URL(context, url) : new URL(url);
            System.out.println(u);
            return u;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}