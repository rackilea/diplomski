import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();    
        StreamSource xsltTransform = new StreamSource(new File("xslt.xml"));
        Transformer transformer = tf.newTransformer(xsltTransform);

        StreamSource source = new StreamSource(new File("source.xml"));

        StreamResult result = new StreamResult(new File("result.html"));
        transformer.transform(source, result);            
    }

}