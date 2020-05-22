import java.io.*;
import java.net.URL;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class HtmlParseDemo {

    public static void main(String[] args) throws Exception {

        Reader reader = new StringReader("<tr><td align=\"center\" width=\"408\"><font color=\"#000000\">"
                + "Hello </font></td><td align=\"center\" width=\"275\"><font color=\"#0000FF\">World! "
               + "</font></td></tr>");
        HTMLEditorKit.Parser parser = new ParserDelegator();
        parser.parse(reader, new HTMLTableParser(), true);
        reader.close();
    }
}
class HTMLTableParser extends HTMLEditorKit.ParserCallback {

    private boolean encounteredATableRow = false;

    public void handleText(char[] data, int pos) {
        if (encounteredATableRow) {
            System.out.println(new String(data));
        }
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        String name1 = (String) a.getAttribute(HTML.Attribute.WIDTH);
        if (t == HTML.Tag.TD) {
            if (name1 != null && name1.equalsIgnoreCase("275") == true) {
//                System.out.println(name1);
                encounteredATableRow = true;
            }
        }
    }

    public void handleEndTag(HTML.Tag t, int pos) {
        if (t == HTML.Tag.TD) {
            encounteredATableRow = false;
        }
    }
}