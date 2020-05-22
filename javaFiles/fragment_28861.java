import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Snippet {
    public static void main(String[] args) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("/bookshelf/shelf/book/*", 
                new InputSource(Snippet.class.getResourceAsStream("/books.xml")),
                XPathConstants.NODESET);
        System.out.println("First  node: " + nodes.item(0));
        System.out.println("Second node: " + nodes.item(1));
    }
}