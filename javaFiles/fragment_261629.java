import javax.xml.stream.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        XMLInputFactory xif = XMLInputFactory.newFactory();
        StreamSource xml = new StreamSource("src/forum14358769/input.xml");
        XMLStreamReader xsr = xif.createXMLStreamReader(xml);

        // Advance to the "To" element.
        while(xsr.hasNext()) {
            if(xsr.isStartElement() && "To".equals(xsr.getLocalName())) {
                break;
            }
            xsr.next();
         }

        // Unmarshal from the XMLStreamReader that has been advanced
        JAXBContext jc = JAXBContext.newInstance(ToType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        ToType toType = unmarshaller.unmarshal(xsr, ToType.class).getValue();
    }

}