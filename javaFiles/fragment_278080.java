import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

public class HelloWorldWithJsoup {
    public static void main(String[] args) {
        String sentence = "Most implementations<img title=\"hello:\" alt=\"hello:{}\" src=\"http://images.doctissimo.fr/hello.gif\" class=\"wysiwyg_smiley\" /> provide ASDF as a module, and you can simply (require \"asdf\").";

        Element body = Jsoup.parse(sentence).body();

        for (TextNode textNode : body.textNodes()) {
            textNode.wrap("<font color=\"white\"></font>");
        }

        System.out.println(body.html());
    }
}