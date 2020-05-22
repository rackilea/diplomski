import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(SMSDetail.class);

        MapAdapter mapAdapter = new MapAdapter();

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setAdapter(mapAdapter);
        File xml = new File("src/forum27182975/input.xml");
        SMSDetail smsDetail = (SMSDetail) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setAdapter(mapAdapter);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(smsDetail, System.out);
    }

}