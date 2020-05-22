import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.Element;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);

        Foo foo = new Foo();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();
        Element element = document.createElementNS("http://www.example.com/FOO", "ns1:foo");
        foo.setObject(element);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new MyNamespacePrefixMapper());
        marshaller.marshal(foo, System.out);
    }

}