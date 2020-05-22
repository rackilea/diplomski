import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        TransformerFactory tf = TransformerFactory.newInstance();
        StreamSource xsltTransform = new StreamSource(new File("xslt.xml"));
        Transformer transformer = tf.newTransformer(xsltTransform);

        JAXBContext jc = JAXBContext.newInstance("com.example.model");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Model model = (Model) unmarshaller.unmarshal(new File("source.xml"));
        // modify the domain model
        JAXBSource source = new JAXBSource(jc, model);

        StreamResult result = new StreamResult(new File("result.html"));
        transformer.transform(source, result);            
    }

}