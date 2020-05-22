import java.util.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Content.class);

        List<String> strings = new ArrayList<String>(2);
        strings.add("foo");
        strings.add("bar");

        Content content = new Content();
        content.setKeywords(strings);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(content, System.out);
    }

}