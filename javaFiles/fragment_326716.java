package forum10854001;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Sitemap.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource xml = new StreamSource("src/forum10854001/input.xml");
        JAXBElement<Sitemap> jaxbElement = unmarshaller.unmarshal(xml, Sitemap.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(jaxbElement, System.out);

    }

}