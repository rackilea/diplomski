package forum13626828;

import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MyClass.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        StringReader xml = new StringReader("<element>data</element>");
        MyClass myClass = (MyClass) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(myClass, System.out);
    }

}