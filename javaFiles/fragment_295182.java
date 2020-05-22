package forum12338288;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        // XML
        JAXBContext jc = JAXBContext.newInstance(WorkList.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum12338288/input.xml");
        WorkList workList = (WorkList) unmarshaller.unmarshal(xml);

        // JSON
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum12338288/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jsonJC = JAXBContext.newInstance(new Class[] {WorkList.class}, properties);

        Marshaller marshaller = jsonJC.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(workList, System.out);
    }

}