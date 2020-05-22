import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class MyJsoupExample {
    public static void main(String args[]) {
        String inputText = "<html><head></head><body><p><img src=\"getCustomers.do?custCode=2&customerId=3334&param1=123\"/></p>"
            + "<p>someText <img src=\"getCustomers.do?custCode=2&customerId=3340&param2=456\"/></p></body></html>";
        Document doc = Jsoup.parse(inputText);
        Elements myImgs = doc.select("img[src*=customerId=3340");
        for (Element element : myImgs) {
            element.replaceWith(new TextNode("my replaced text", ""));
        }
        System.out.println(doc.toString());
    }
}