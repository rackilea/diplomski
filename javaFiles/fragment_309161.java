import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Demo {

    public static void main(String[] args) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document dDoc = builder.parse("E:/test.xml");

            XPath xPath = XPathFactory.newInstance().newXPath();
            xPath.setNamespaceContext(new MyNamespaceContext());
            NodeList nl = (NodeList) xPath.evaluate("/ns:root/ns:author", dDoc, XPathConstants.NODESET);
            System.out.println(nl.getLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyNamespaceContext implements NamespaceContext {

        public String getNamespaceURI(String prefix) {
            if("ns".equals(prefix)) {
                return "http://www.mydomain.com/schema";
            }
            return null;
        }

        public String getPrefix(String namespaceURI) {
            return null;
        }

        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }

    }

}