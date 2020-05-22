package forum11078850;

import java.io.FileReader;
import javax.xml.bind.*;

public class ObjectFactoryTest {
    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("src/forum11078850/input.xml");
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object obj = unmarshaller.unmarshal(reader);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, System.out);
    }
}