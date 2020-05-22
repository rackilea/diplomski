import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class example {

    public static void main(String[] args) throws IOException {
        String url = "https://www.google.com.hk/finance?q=0023&ei=yF14VYC4F4Wd0ASb64CoCw";
        Document doc = Jsoup.connect(url).get();
        Element content = doc.select("meta[itemprop=price]").first();
        System.out.println(content.attr("content"));
    }
}