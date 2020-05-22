import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Appels.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum20637070/input.xml");
        Appels appels = (Appels) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(appels, System.out);
    }

}