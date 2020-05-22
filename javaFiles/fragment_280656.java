import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main { 
    public static void main(String[]args) throws Exception{
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(new StreamSource(new File("xsl.xsl")));
        transformer.transform(new StreamSource(new File("schema.xsd")), new StreamResult(System.out));
    }
}