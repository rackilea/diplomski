package forum11698160;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Bobar.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11698160/input.xml");
        Bobar bobar =  (Bobar) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(bobar, System.out);
    }

}