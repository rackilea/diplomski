import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;

public class Demo {

    public static void main(String[] args) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xsltTransform = new StreamSource(new File("xslt.xml"));
        Transformer transformer = tf.newTransformer(xsltTransform);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("source.xml"));
        // modify the document
        DOMSource source = new DOMSource(document);

        StreamResult result = new StreamResult(new File("result.html"));
        transformer.transform(source, result);  
    }

}