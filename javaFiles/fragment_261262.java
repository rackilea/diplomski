import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Test {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup
                .connect(
                        "http://bulbapedia.bulbagarden.net/wiki/Bulbasaur_(Pok%C3%A9mon)")
                .get();
        Elements newsHeadlines = doc.select("#mw-content-text p");
        for (Object o : newsHeadlines) {
            System.out.println(o.toString());
        }

    }

}