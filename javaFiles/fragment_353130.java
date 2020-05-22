import java.io.File;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsoup {
    public static void main(String[] args) throws Exception {
        System.out.println("Starteed");

        File file = new File("A-Z list of 11930 World Colleges & Universities.html");
        Document doc = Jsoup.parse(file, "UTF-8");

        Elements cells = doc.select("td.i");

        Iterator<Element> iterator = cells.iterator();

        while (iterator.hasNext()) {
            Element cell = iterator.next();
            String university = cell.select("a").text();
            String country = cell.nextElementSibling().select("img").attr("alt");

            System.out.printf("country : %s, university : %s %n", country, university);
        }
    }
}