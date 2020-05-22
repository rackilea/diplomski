package forum11870107;

import java.util.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum11870107/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {PersonCollectionResponse.class}, properties);

        PersonCollectionResponse pcr = new PersonCollectionResponse();

        Person person1 = new Person();
        person1.setId(1);
        person1.setName("Danny Parker");
        pcr.getPeople().add(person1);
        Address address1 = new Address();
        address1.setLocality("Zoo York");
        address1.setState("New York");
        address1.setZip("10014");
        person1.setAddress(address1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setName("Oscar the Grouch");
        pcr.getPeople().add(person2);
        Address address2 = new Address();
        address2.setLocality("San Francisco");
        address2.setState("California");
        address2.setZip("94102");
        person2.setAddress(address2);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(pcr, System.out);
    }

}