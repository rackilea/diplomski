import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class UseXMLToHTML {

    public static void main(String[] args) throws TransformerException {
        StreamResult result = new StreamResult(new File("output.html"));
        StreamSource source = new StreamSource(new File("input.xml"));
        StreamSource xslt = new StreamSource(new File("transform.xslt"));

        Transformer transformer = TransformerFactory.newInstance().newTransformer(xslt);

        transformer.transform(source, result);
    }
}