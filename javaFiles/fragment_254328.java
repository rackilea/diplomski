import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(WebResponse.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum21797000/input.xml");
        WebResponse wr = (WebResponse) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(wr, System.out);
    }

}