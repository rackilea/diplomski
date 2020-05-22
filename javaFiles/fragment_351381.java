import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

...

  String xml = "<...>";
  String expression = "/Enrollment/FirstName";

  DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
  builderFactory.setNamespaceAware(true);
  DocumentBuilder builder = builderFactory.newDocumentBuilder();
  InputStream in = new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8")));
  Document document = builder.parse(in);

  XPath xpath = XPathFactory.newInstance().newXPath();
  Node firstNameNode = (Node) xpath.evaluate(expression, document, XPathConstants.NODE);
  String firstName = firstNameNode.getTextContent();