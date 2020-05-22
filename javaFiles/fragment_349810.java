package forum10388261;

import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Author.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum10388261/input.xml");
        Author author = (Author) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(author, System.out);
    }

}