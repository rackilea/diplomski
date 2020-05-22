import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DocBuilderTest {

    private String filePath = "src/test/resource/doc.xml";

    @Test
    public void builder()
        throws ParserConfigurationException, IOException, SAXException, TransformerException {
        System.out.println(processFile("parentNode", "value", "childNode"));
    }

    private String processFile(String parentNode, String value, String childNode)
        throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filePath);
        Node pNode = doc.getElementsByTagName(parentNode).item(0);

        for (int i = 0; i < 5; i++) {
            String nodeValue = value + i;

            Element newNode = doc.createElement(childNode);
            newNode.appendChild(doc.createTextNode(nodeValue));
            pNode.appendChild(newNode);
        }

        return toPrettyPrintString(doc);
    }

    // From https://stackoverflow.com/a/139096/7421645
    private String toPrettyPrintString(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        // initialize StreamResult with File object to save to file
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);
        transformer.transform(source, result);
        return result.getWriter().toString();
    }
}