package stackoverflow;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupTest {
    public static void main(String[] args) throws IOException {
        InputStream in = JSoupTest.class.getResourceAsStream("JSoupTest.txt");

        String html = IOUtils.toString(in);

        Document doc = Jsoup.parse(html);

        Elements divs = doc.select("DIV");
        System.out.println(divs);

        Element div = divs.get(2);
        System.out.println("Monster in Black".equals(div.text()));
    }
}