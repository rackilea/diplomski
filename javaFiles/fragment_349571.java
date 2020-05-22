import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class IdFinder
{
    public static void main(String[] args)
            throws Exception
    {
        File fXmlFile = new File("C:/Users/user2121/osm.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document document = dBuilder.parse(fXmlFile);

        XPath xPath = XPathFactory.newInstance().newXPath();

        String expr0 = "/osm/node[@lat=53.0337395]/@id";
        NodeList nodeList = (NodeList) xPath.compile(expr0).evaluate(document, XPathConstants.NODESET);

        System.out.println("Matches: " + nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeValue());
        }
    }
}