import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class da {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {

            Document doc = Jsoup.connect("http://www.imdb.com/chart/top").get();
            Elements ratings = doc.select(".ratingColumn.imdbRating");

            float suma = 0;

            for(int i = 0; i < ratings.size(); i++)
                suma = suma + Float.parseFloat(ratings.get(i).child(0).text());

            System.out.println(suma/250);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}