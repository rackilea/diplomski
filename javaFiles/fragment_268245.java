package forum15875338;

import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    private static final String XML = "<root><foo>Hello</foo><bar>World</bar></root>";

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Unmarshal #1 = Default Unmarshal
        System.out.println("Unmarshal #1");
        Root root = (Root) unmarshaller.unmarshal(new StringReader(XML));
        marshaller.marshal(root, System.out);

        // Unmarshal #2 - Override Default ValidationEventHandler
        System.out.println("Unmarshal #2");
        unmarshaller.setEventHandler(new ValidationEventHandler() {
            @Override
            public boolean handleEvent(ValidationEvent event) {
                System.out.println(event.getMessage());
                return false;
            }
        });
        unmarshaller.unmarshal(new StringReader(XML));
    }

}