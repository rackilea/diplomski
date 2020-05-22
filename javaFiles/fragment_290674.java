import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestRSSFeed {

    public static void main(String[] args) {
        try {
            // Read the feed...
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse("http://stackoverflow.com/feeds/tag?tagnames=java&sort=newest");
            Element root = doc.getDocumentElement();

            // Create a xPath instance
            XPath xPath = XPathFactory.newInstance().newXPath();
            // Find all the nodes that are named <entry...> any where in
            // the document that live under the parent node...
            XPathExpression expression = xPath.compile("//entry");
            NodeList nl = (NodeList) expression.evaluate(root, XPathConstants.NODESET);

            System.out.println("Found " + nl.getLength() + " items...");
            for (int index = 0; index < nl.getLength(); index++) {
                Node node = nl.item(index);
                // This is a sub node search.
                // The search is based on the parent node and looks for a single
                // node titled "title" that belongs to the parent node...
                // I did this because I'm only expecting a single node...
                expression = xPath.compile("title");
                Node child = (Node) expression.evaluate(node, XPathConstants.NODE);
                System.out.println(child.getTextContent());
            }

        } catch (IOException | ParserConfigurationException | SAXException exp) {
            exp.printStackTrace();
        } catch (XPathExpressionException ex) {
            ex.printStackTrace();
        }
    }

}