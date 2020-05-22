import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupValidate {

    public static void main(String[] args) throws Exception {

        String invalidHtml = "<div id=\"myDivId\" ' class = claasnamee value='undaa' > <<p> p tagil vanne <br> <span> span close cheythillee!!  </p> </div>";

        Document initialDoc = Jsoup.parseBodyFragment(invalidHtml);

        Document validatedDoc = Jsoup.connect("http://validator.w3.org/check")
                .data("fragment", initialDoc.html())
                .data("st", "1")
                .post();

        System.out.println("******");
        System.out.println("Errors");
        System.out.println("******");
        for(Element error : validatedDoc.select("li.msg_err")){
            System.out.println(error.select("em").text() + " : " + error.select("span.msg").text());
        }

        System.out.println();
        System.out.println("**************");
        System.out.println("Cleaned output");
        System.out.println("**************");
        Document cleanedOuput = Jsoup.parse(validatedDoc.select("pre.source").text());
        cleanedOuput.select("meta[name=generator]").first().remove();
        cleanedOuput.outputSettings().indentAmount(4);
        cleanedOuput.outputSettings().prettyPrint(true);
        System.out.println(cleanedOuput.html());
    }

}