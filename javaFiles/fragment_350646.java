import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class ThrowawayCode {
    public static void main(String[] args) throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element parentNode = document.createElement("parent");
        document.appendChild(parentNode);
        Text textNode = document.createTextNode("parent text");
        Element childNode = document.createElement("child");
        parentNode.appendChild(childNode);
        childNode.appendChild(textNode);
        childNode = document.createElement("secondChild");
        textNode = document.createTextNode("second child text");
        parentNode.appendChild(childNode);
        childNode.appendChild(textNode);

        Source source = new DOMSource(document);
        StringWriter writer = new StringWriter();
        Result result = new StreamResult(writer);
        TransformerFactory.newInstance().newTransformer().transform(source, result);
        System.out.println(writer.toString());
    }
}