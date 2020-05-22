package forum10511601;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Example.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum10511601/input.xml");
        Example example = (Example) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(example, System.out);
    }

}