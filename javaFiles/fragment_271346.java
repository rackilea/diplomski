import java.io.*;
import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Foo foo = new Foo();
        foo.setBar("Hello World");
        marshal(jc, foo);

        Object jaxbElement = new JAXBElement<Foo>(new QName("root"), Foo.class, foo);
        marshal(jc, jaxbElement);
    }

    private static void marshal(JAXBContext jc, Object jaxbElement) throws Exception {
        Marshaller m = jc.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        BufferedWriter writer = new BufferedWriter(stringWriter);
        m.marshal(jaxbElement, writer);
        writer.close();
        System.out.println(stringWriter.toString());
    }

}