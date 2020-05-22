package forum13652303;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Customer.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File json = new File("src/forum13652303/input.json");
        Customer customer = (Customer) unmarshaller.unmarshal(json);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(customer, System.out);
    }

}