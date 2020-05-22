import java.io.*;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class Demo {

  private static final String XML =
      "<?xml version=\"1.0\"?>\n"
          + "<data>\n"
          + "  <model1>\n"
          + "    <element1>\n"
          + "      <id>1</id>\n"
          + "      <name>John</name>\n"
          + "      <address>xxx</address>\n"
          + "    </element1>\n"
          + "    <element1>\n"
          + "      <id>2</id>\n"
          + "      <name>Tom</name>\n"
          + "      <address>yyy</address>\n"
          + "    </element1>\n"
          + "  </model1>\n"
          + "  <model2>\n"
          + "    <element2>\n"
          + "      <uid />\n"
          + "      <something />\n"
          + "    </element2>\n"
          + "  </model2>"
          + "</data>";

  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    Document source;
    try (InputStream in = new ByteArrayInputStream(XML.getBytes(StandardCharsets.UTF_8))) {
      source = factory.newDocumentBuilder().parse(in);
    }

    // Extract
    XPath xPath = XPathFactory.newInstance().newXPath();
    XPathExpression expr = xPath.compile(args[0]);

    NodeList nodeList = (NodeList) expr.evaluate(source, XPathConstants.NODESET);

    // Export
    Document target = factory.newDocumentBuilder().newDocument();
    Element data = target.createElement("data");
    Element model1 = target.createElement("model1");
    data.appendChild(model1);
    target.appendChild(data);
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      Node newNode = target.importNode(node, true);
      model1.appendChild(newNode);
    }
    System.out.println(getStringFrom(target));
  }

  private static String getStringFrom(Document doc) throws TransformerException {
    DOMSource domSource = new DOMSource(doc);
    StringWriter writer = new StringWriter();
    StreamResult result = new StreamResult(writer);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    // set indent
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
    transformer.transform(domSource, result);
    return writer.toString();
  }
}