import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import sub.optimal.xpath.FooBar;

public class FilteredUnmarshalling {

    public static void main(String[] args) throws Exception {
        String in = "<XmlParent>\n"
                + "    <name>koraytugay</name>\n"
                + "    <bar>\n"
                + "        <baz>\n"
                + "            <qux>00000001</qux>\n"
                + "        </baz>\n"
                + "    </bar>\n"
                + "</XmlParent>";
        byte[] bytes = in.getBytes();

        JAXBContext context = JAXBContext.newInstance(FooBar.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        XMLInputFactory factory = XMLInputFactory.newInstance();

        String[] tagNamesToFilter = {"bar", "baz"};
        Set<QName> tagsToFilter = new HashSet<>();
        for (String name : tagNamesToFilter) {
            tagsToFilter.add(new QName(name));
        }

        try (InputStream reader = new ByteArrayInputStream(bytes)) {
            XMLEventReader xmlEventReader=factory.createXMLEventReader(reader);
            FooBar fooBar = (FooBar)unmarshaller.unmarshal(
                    new FilteringlXmlEventReader(xmlEventReader,tagsToFilter));
            System.out.println("name: " + fooBar.getName());
            System.out.println("qux : " + fooBar.getQux());
        }
    }
}