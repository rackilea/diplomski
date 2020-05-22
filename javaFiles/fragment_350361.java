import generated.XGroup;
import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance("generated");

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("input.xml");
        JAXBElement<XGroup> je = (JAXBElement<XGroup>) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(je, System.out);
    }

}