package forum9137171;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foos.class);
        System.out.println(jc);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum9137171/input.xml");
        Foos foos = (Foos) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foos, System.out);
    }

}