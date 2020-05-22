public class JSoupTest {
   public static void main(String[] args) throws IOException {
    String html = "<div itemprop=\"doseSchedule\">\n"
            + "text1\n"
            + "</div>\n"
            + "<h3><a id=\"SP3\">TITLE</a></h3>\n"
            + "<div>text2</div>\n"
            + "<div itemprop=\"warning\">\n"
            + "text3\n"
            + "</div>";

    Document doc = Jsoup.parse(html);

    Element e = doc.select("h3").first().nextElementSibling();

    System.out.println(e.text());
    }
}