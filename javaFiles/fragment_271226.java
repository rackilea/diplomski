package JsoupTest;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTesting {

    public static void main(String[] args) throws IOException {

        File input = new File("html.html"); //path to html.html
        Document doc = Jsoup.parse(input, "UTF-8");

        Elements contents = doc.getElementsByClass("data");

        for (Element content : contents) {
            String name = content.getElementsByClass("name").first().html();
            String stat = content.getElementsByClass("stat").first().html();
            String stat2 = content.getElementsByClass("stat2").first().html();
            System.out.println("name: " + name);
            System.out.println("stat: " + stat);
            System.out.println("stat2: " + stat2 + "\n----");
        }

    }

}