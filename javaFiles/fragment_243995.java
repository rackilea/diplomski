import java.io.File;
import java.math.BigDecimal;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum18440987/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);

        nullOrAbsent("foo", root.foo);
        nullOrAbsent("bar", root.bar);
        nullOrAbsent("baz", root.baz);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

    private static void nullOrAbsent(String property, JAXBElement<BigDecimal> value) {
        System.out.print(property);
        if(null == value) {
            System.out.print(":  ABSENT - ");
        } else if(value.isNil()) {
            System.out.print(":  NIL - ");
        } else {
            System.out.print(":  VALUE - ");
        }
        System.out.println(JAXBIntrospector.getValue(value));
    }

}