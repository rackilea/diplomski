import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlTest {

    public static void main(String[] args) throws Exception {
        String xml = "<name>\n" +
                "<value>123</value>\n" +
                "<value>456</value>\n" +
                "<value>789</value>\n" +
                "</name>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        NodeList list = (NodeList) xpath.evaluate("name/value", doc, XPathConstants.NODESET);

        for (int i = 0; i < list.getLength(); ++i) {
            Node node = list.item(i);
            System.out.println(node.getNodeName());
        }
    }

}