import java.io.*;
import javax.xml.stream.*;
import javax.xml.transform.*;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.dom.DOMResult;
import org.w3c.dom.*

public class Demo {

    public static void main(String[] args) throws Exception  {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileReader("input.xml"));
        xsr.nextTag(); // Advance to statements element

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        while(xsr.nextTag() == XMLStreamConstants.START_ELEMENT) {
            DOMResult result = new DOMResult();
            t.transform(new StAXSource(xsr), result);
            Node domNode = result.getNode();
        }
    }

}