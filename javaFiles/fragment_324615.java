import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ExtractVar {

    static String xml = "<tunnel>" +
    "<units>" +
      "<entry name=\"tunnel.1\">"+
        "<ip>"+
       "   <entry name=\"$ABC\"/>"+
      "  </ip>"+
     "   <interface-management-profile>mgt</interface-management-profile>"+
    "  </entry>"+
   " </units>"+
  "</tunnel>";


    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = db.parse(new InputSource(new StringReader(xml)));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPathExpression xpath = xpathFactory.newXPath().compile("//entry");

        NodeList entryNodes = (NodeList) xpath.evaluate(document, XPathConstants.NODESET);
        for(int i =0; i<entryNodes.getLength(); i++) {
            Node n = entryNodes.item(i);
            String nodeValue = n.getAttributes().getNamedItem("name").getNodeValue();
            if(nodeValue.startsWith("$")) {
                System.out.println(nodeValue.substring(1, nodeValue.length()));
            }
        }
    }
}