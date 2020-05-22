import org.jsoup.Jsoup;
import org.jsoup.nodes.*;

public class Soup {
  public static void main(String[] args) {
    String data = "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"> <tr> <td class=\"reportheader\" align=\"left\" nowrap width=\"720\">Outside my Dreams</td> </tr> </table>";
    Document doc = Jsoup.parse(data);
    StringBuilder tags = new StringBuilder();
    for (Element el : doc.select("body *:not([id])")) {
      tags.append(el.tagName());
      tags.append(' ');
    }
    System.out.println(tags);
  }
}