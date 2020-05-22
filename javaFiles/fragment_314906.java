package forum17527941;

import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/forum17527941/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);
        xsr = new StreamReaderDelegate(xsr) {

            @Override
            public String getLocalName() {
                String localName = super.getLocalName();
                if("resource".equals(localName) || "data".equals(localName) || "container".equals(localName)) {
                    return "stackoverflow";
                }
                return localName;
            }
        };

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(xsr);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://www.example.eu/test ResourceSchema.xsd");
        marshaller.marshal(root, System.out);
    }

}