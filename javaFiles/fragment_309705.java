package pojo;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Party.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/pojo/input.xml");
        Party party = (Party) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(party, System.out);
    }

}