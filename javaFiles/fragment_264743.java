import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {
    public static void main(String[] args) throws Exception {
        final Document document = Jsoup.parse("<html><head/><body><a href=\"#\" class=\"artist\">Soulive<span class=\"create-play\">Play</span></a></body></html>");
        final Element elem = document.getElementsByAttributeValue("class", "artist").first();
        System.out.println(elem.ownText());
    }
}