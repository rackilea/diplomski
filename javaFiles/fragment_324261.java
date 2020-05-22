import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Response.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum17141154/input.xml");
        Response response = (Response) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(response, System.out);
    }

}