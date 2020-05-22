import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class App {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(FontStyle.class);

        // unmarshall "example.xml"
        File exampleFile = new File("example.xml");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        FontStyle fontStyle = (FontStyle) jaxbUnmarshaller.unmarshal(exampleFile);

        // marshall back to XML and print the result
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); // removes xml declaration line for consistency with "example.xml" file
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(fontStyle, System.out);
    }
}