import java.io.StringReader;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class, ObjectFactory.class);

        StringReader xml = new StringReader("<foo><C>Hello World</C></foo>");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Foo foo = (Foo) unmarshaller.unmarshal(xml);

        JAXBElement<?> aOrBOrCOrD = foo.aOrBOrCOrD;
        System.out.println(aOrBOrCOrD.getName().getLocalPart());
        System.out.println(aOrBOrCOrD.getDeclaredType());
        System.out.println(aOrBOrCOrD.getValue());
    }

}