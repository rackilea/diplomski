package forum11193953;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Mappings.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml= new File("src/forum11193953/input.xml");
        Mappings mappings = (Mappings) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(mappings, System.out);
    }

}