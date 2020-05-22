import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class SpringXMLParser {

    public static void parse(String file) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dbf.newDocumentBuilder();
        Document doc = docBuilder.parse(new FileInputStream(file));
        Element root = doc.getDocumentElement();
        org.w3c.dom.NodeList nodeList = root.getElementsByTagName("key");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.print(((Node) nodeList.item(i))
                     .getAttributes().getNamedItem("keyname"));
            System.out.println("\tvalue: "+((Node) nodeList.item(i)).getTextContent());
        }

    }

    public static void main(String args[]) throws Exception {
        parse("resources/xml5.xml");
    }
}