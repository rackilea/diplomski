import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Emp.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum15240702/input.xml");
        Emp emp = (Emp) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(emp, System.out);
    }

}