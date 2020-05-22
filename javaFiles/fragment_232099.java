import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class testxml {

private String filepath = "src/xml.xml";

public void parse() {

    File file = new File(filepath);

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db;
    try {
        db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        Element docElem = doc.getDocumentElement();
        NodeList nl1 = docElem.getElementsByTagName("Oldpassword");

        for(int i = 0; i < nl1.getLength(); i++) {
            Element entry = (Element)nl1.item(i);
            System.out.println(entry.getFirstChild().getNodeValue());
        }

        NodeList nl2 = docElem.getElementsByTagName("Newpassword");

        for(int i = 0; i < nl2.getLength(); i++) {
            Element entry = (Element)nl2.item(i);
            System.out.println(entry.getFirstChild().getNodeValue());
        }

    } catch (ParserConfigurationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public static void main(String args[]) {

    testxml x = new testxml();
    x.parse();

}