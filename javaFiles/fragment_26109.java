import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {FileDocument.class}, properties);


        Metadata m1 = new Metadata();
        m1.source = "metadata.source1";

        Metadata m2 = new Metadata();
        m2.source = "metadata.source2";

        List<Metadata> metadata = new ArrayList<Metadata>();
        metadata.add(m1);
        metadata.add(m2);

        FileDocument fd = new FileDocument();
        fd.metadata = metadata;

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(fd, System.out);
    }

}