import java.io.StringReader;
import java.util.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put("eclipselink.media-type", "application/json");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Student.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader json = new StringReader("{\"0\":{\"0\":\"Rockey\",\"1\":\"John\"}}");
        Student student = (Student) unmarshaller.unmarshal(json);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(student, System.out);
    }

}