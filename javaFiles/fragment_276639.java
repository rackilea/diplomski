import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

...
Document doc = Jsoup.parse(html);
for (Element input : doc.select("input")){
    System.out.println(input.attr("name"));
}