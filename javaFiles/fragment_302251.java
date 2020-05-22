import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

 public static void main(String[] args) {
  Document doc = null;

  try {
   doc = Jsoup.connect("https://sites.google.com/site/aenmakmech/tmemata").get();
   Elements links = doc.select("a[href]");

   String[] urls = new String[links.size()];
   for (int i = 0; i < links.size(); i++) {
    urls[i] = links.get(i).attr("href");
    //System.out.println(prices[i]);
   }

   String specific_url = urls[77];
   System.out.print(specific_url);

  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }


 }
};