package forum13884782;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(AddressMap.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13884782/input.xml");
        AddressMap addressMap = (AddressMap) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(addressMap, System.out);
    }

}