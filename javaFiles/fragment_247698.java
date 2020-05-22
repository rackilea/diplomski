import java.io.File;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.select.Elements;

public static void main(String[] args) {
    String sourceDir = "C:/Users/admin/Desktop/test.html";
    test(sourceDir);
}

private static void test(String htmlFile) {
    File input = null;
    Document doc = null;
    Elements classEles = null;

    try {
        input = new File(htmlFile);
        doc = Jsoup.parse(input, "ASCII", "");
        doc.outputSettings().charset("ASCII");
        doc.outputSettings().escapeMode(EscapeMode.base);

        /** Find all SPAN element with matched CLASS name **/
        classEles = doc.select("span.label.label-info.pull-right");

        if (classEles.size() > 0) {
            String number = classEles.get(0).text();
            System.out.println("number: " + number);
        }
        else {
            System.out.println("No SPAN element found with class label label-info pull-right.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}