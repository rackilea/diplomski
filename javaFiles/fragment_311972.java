package forum10243679;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    private static final String XML = "<root/>";

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        JAXBIntrospector jaxbIntrospector = jc.createJAXBIntrospector();

        Object object = unmarshaller.unmarshal(new StringReader(XML));
        System.out.println(object.getClass());
        System.out.println(jaxbIntrospector.getValue(object).getClass());

        Object jaxbElement = unmarshaller.unmarshal(new StreamSource(new StringReader(XML)), Root.class);
        System.out.println(jaxbElement.getClass());
        System.out.println(jaxbIntrospector.getValue(jaxbElement).getClass());
    }

}