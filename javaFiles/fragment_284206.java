import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSoupTest {
    /*
     Outputs:
        Members can login for access to exclusive content, event booking, shop discounts and more...
        Your Login Details
        Your Membership Number
        Enter your membership number
        Password
        Enter your password
        Remember Me
        Forgot your password?
        Haven't registered yet?
     */
    public static void main(String[] args) throws IOException {
        String url = "http://localhost/test.html";
        List<String> strings = getStringsFromUrl(url, null);
        for(String string : strings) {
            System.out.println(string);
        }
    }

    private static List<String> getStringsFromUrl(String url, String cssQuery) throws IOException {
        Document document = Jsoup.connect(url).get();
        Elements elements = StringUtil.isBlank(cssQuery)
                ? document.getElementsByTag("body")
                : document.select(cssQuery);

        List<String> strings = new ArrayList<String>();
        elements.traverse(new TextNodeExtractor(strings));
        return strings;
    }

    private static class TextNodeExtractor implements NodeVisitor {
        private final List<String> strings;

        public TextNodeExtractor(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public void head(Node node, int depth) {
            if (node instanceof TextNode) {
                TextNode textNode = ((TextNode) node);
                String text = textNode.getWholeText();
                if (!StringUtil.isBlank(text)) {
                    strings.add(text);
                }
            }
        }

        @Override
        public void tail(Node node, int depth) {}
    }
}