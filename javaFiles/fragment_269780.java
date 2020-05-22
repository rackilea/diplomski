import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestXPath101 {

    public static void main(String[] args) {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("Test.xml"));
            XPath xPath = XPathFactory.newInstance().newXPath();
            XPathExpression exp = xPath.compile("//cricket");
            NodeList nl = (NodeList)exp.evaluate(doc, XPathConstants.NODESET);
            System.out.println("Found " + nl.getLength() + " results");
        } catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException ex) {
            ex.printStackTrace();
        }
    }

}