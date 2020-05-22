import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupFrame {

    public static void main(String[] args) throws Exception {
        Document doc =  Jsoup.parse(new File("t2.html"), "UTF-8");
        doc.select("area#area1").after("<area id=\"newArea\" />");
        System.out.println(doc.html()); 
    }

}