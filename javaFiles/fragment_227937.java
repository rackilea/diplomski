import java.io.FileInputStream;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(Categories.class);

        XMLInputFactory xif = XMLInputFactory.newInstance();
        FileInputStream fis = new FileInputStream("input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(fis);
        xsr.nextTag();
        String noNamespaceSchemaLocation = xsr.getAttributeValue(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "noNamespaceSchemaLocation");
        System.out.println(noNamespaceSchemaLocation);

        Unmarshaller um = context.createUnmarshaller();
        Categories response = (Categories) um.unmarshal(xsr);
    }
}