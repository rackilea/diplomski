import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(FindEventsResponse.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StreamSource xml = new StreamSource("src/forum23806625/input.xml");
        JAXBElement<FindEventsResponse> response = unmarshaller.unmarshal(xml, FindEventsResponse.class);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(response, System.out);
    }

}