import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;
import java.util.*;

public class Test
{
    public static void main(String[] args) throws IOException {
        System.out.println("Started");

        String url = "http://www.4icu.org/reviews/index2.htm";
        Document doc = Jsoup.connect(url).userAgent("Mozilla").get();

        Elements cells = doc.select("td.i");

        Iterator<Element> iterator = cells.iterator();  
        while (iterator.hasNext()) {
            Element cell = iterator.next();

            String university = Jsoup.parse((cell.select("a").text())).text();
            String country = cell.nextElementSibling().select("img").attr("alt");
            System.out.printf("country : %s, university : %s %n", country, university);
        }
    }
}