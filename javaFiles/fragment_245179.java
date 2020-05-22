import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;   
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


public class XML {

    public static void main (String[] args) throws Exception {

        String xml = "<objects><circle color='red'/><circle color='green'/><rectangle>hello</rectangle><glumble/></objects>";

        // parse
        InputStream in = new ByteArrayInputStream(xml.getBytes("utf-8"));
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);

        // process
        Node objects = doc.getDocumentElement();
        for (Node object = objects.getFirstChild(); object != null; object = object.getNextSibling()) {
            if (object instanceof Element) {
                Element e = (Element)object;
                if (e.getTagName().equalsIgnoreCase("circle")) {
                    String color = e.getAttribute("color");
                    System.out.println("It's a " + color + " circle!");
                } else if (e.getTagName().equalsIgnoreCase("rectangle")) {
                    String text = e.getTextContent();
                    System.out.println("It's a rectangle that says \"" + text + "\".");
                } else {
                    System.out.println("I don't know what a " + e.getTagName() + " is for.");
                }
            }
        }

    }

}