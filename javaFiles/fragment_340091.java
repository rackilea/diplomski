package forum6838882;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext databaseJC = JAXBContext.newInstance(Item.class);
        Unmarshaller databaseUnmarshaller = databaseJC.createUnmarshaller();
        File databaseXML = new File("src/forum6838882/database.xml");
        Item item = (Item) databaseUnmarshaller.unmarshal(databaseXML);

        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum6838882/binding.xml");
        JAXBContext resultJC = JAXBContext.newInstance(new Class[] {Item.class}, properties);
        Marshaller resultMarshaller = resultJC.createMarshaller();
        resultMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        resultMarshaller.marshal(item, System.out);
    }
}