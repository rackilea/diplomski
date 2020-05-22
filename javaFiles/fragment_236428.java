import java.io.File;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Root.class, ObjectFactory.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum20076018/input.xml");
        Root root = (Root) unmarshaller.unmarshal(xml);

        System.out.println("Was fooString set?  " + root.isSetFooString());
        System.out.println("Was barString set?  " + root.isSetBarString());
        System.out.println("Was fooJAXBElement set?  " + (root.getFooJAXBElement() != null));
        System.out.println("Was barJAXBElement set?  " + (root.getBarJAXBElement() != null));

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}