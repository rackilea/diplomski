import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TyrePrice {

    public static void main(String[] args) {
        try {
            String URL = "http://www.mimovrste.com/letne-avtomobilske-pnevmatike";
            Document doc = Jsoup.connect(URL).get();

            // Approach 1
            String cheapest = doc.select("input[name=p-min]").first().attr("value");
            System.out.println(cheapest); // Prints 31.65

            // Approach 2
            doc = Jsoup.connect(URL).data("0", "_price").get();
            cheapest = doc.select("b.lst-product-item-price").first().text();
            System.out.println(cheapest); // Prints 31,65 €

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}