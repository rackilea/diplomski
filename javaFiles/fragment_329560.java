import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupDemo {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost/mystikrpg/post.php?players");
        Document doc = Jsoup.parse(url, 3*1000);

        String text = doc.body().text();

        System.out.println(text); // outputs 1
    }
}