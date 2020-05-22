package forum10109418;

import java.io.FileInputStream;
import javax.xml.bind.*;
import javax.xml.stream.*;
import javax.xml.stream.util.StreamReaderDelegate;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Details.class);

        XMLInputFactory xif = XMLInputFactory.newFactory();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("src/forum10109418/input.xml"));
        xsr = new StreamReaderDelegate(xsr) {
            @Override
            public String getLocalName() {
                String localName = super.getLocalName();
                if(localName.startsWith("picture") && !localName.equals("pictures")) {
                    return "picture";
                }
                return localName;
            }

        };
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Details details = (Details) unmarshaller.unmarshal(xsr);
        System.out.println(details.getPictures().size());
    }

}