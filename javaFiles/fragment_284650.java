package forum11417620;

import java.io.File;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContextFactory.createContext(new Class[] {Person.class}, null);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum11417620/input.xml");
        Person person = (Person) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(person, System.out);
    }

}