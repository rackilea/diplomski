package forum11333165;

import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Address.class);

        StringReader xml = new StringReader("<Address><Name>Test</Name></Address>");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Address address = (Address) unmarshaller.unmarshal(xml);

        System.out.println(address.getPostalAddress().getState());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(address, System.out);
    }

}