import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Sample {
    public static void main(String[] args) {
        String url = "http://homeport8.apl.com/gentrack/blRoutingPopup.do";

        try {
            Connection.Response response = Jsoup.connect(url)
                    .data("blNbr", "999061985")  // tracking number
                    .method(Connection.Method.POST)
                    .execute();

            Element tableElement = response.parse().getElementsByTag("table")
                    .get(2).getElementsByTag("table")
                    .get(2);

            Elements trElements = tableElement.getElementsByTag("tr");
            ArrayList<ArrayList<String>> tableArrayList = new ArrayList<>();

            for (Element trElement : trElements) {
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    columnList.add(i, trElement.children().get(i).text());
                }
                tableArrayList.add(columnList);
            }

            System.out.println("Origin/Location: "
                    +tableArrayList.get(1).get(1));// row and column number

            System.out.println("Discharge Port/Container Arrival Date: "
                    +tableArrayList.get(5).get(3));


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}