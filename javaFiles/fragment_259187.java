import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
...
String in = "<XmlParent>\n"
        + "    <name>koraytugay</name>\n"
        + "    <bar>\n"
        + "        <baz>\n"
        + "            <qux>00000001</qux>\n"
        + "        </baz>\n"
        + "    </bar>\n"
        + "</XmlParent>";
byte[] bytes = in.getBytes();

DocumentBuilder builder = DocumentBuilderFactory.newInstance()
        .newDocumentBuilder();
Document document = builder.parse(new ByteArrayInputStream(bytes));
XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();
String name = xpath.evaluate("/XmlParent/name", document);
String qux = xpath.evaluate("/XmlParent/bar/baz/qux", document);
System.out.println("name = " + name);
System.out.println("qux = " + qux);