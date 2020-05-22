package forum13272288;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Wrapper.class, Person.class, Address.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StreamSource personsXML = new StreamSource("src/forum13272288/persons.xml");
        JAXBElement<Wrapper> wrapper1 = unmarshaller.unmarshal(personsXML, Wrapper.class);
        marshaller.marshal(wrapper1, System.out);

        StreamSource addressesXML = new StreamSource("src/forum13272288/addresses.xml");
        JAXBElement<Wrapper> wrapper2 = unmarshaller.unmarshal(addressesXML, Wrapper.class);
        marshaller.marshal(wrapper2, System.out);
    }

}