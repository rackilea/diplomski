import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;

public class Foo {
  // Error handling should be done, but I can't know what you want to happen
  // in case of broken XML.
  public static void main(String[] args) throws Exception {
    String xml =
        "<customer>\n"
      + "   <name>Customer name</name>\n"
      + "   <address>\n"
      + "      <postalcode>94510</postalcode>\n"
      + "      <town>Green Bay</town>\n"
      + "   </address>\n"
      + "   <phone>0645878787</phone>\n"
      + "</customer>";

    // XPath expression: It selects all address nodes under /customer
    // that have a postalcode child whose text is 94510
    String selection = "/customer/address[postalcode=94510]";

    // Lots of fluff -- the XML API is full of factories; don't mind them.
    // What all this does is to parse the document from the string.
    InputStream     source   = new ByteArrayInputStream(xml.getBytes());
    Document        document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(source);

    // Create a list of nodes that match our XPath expression
    XPathExpression xpath    = XPathFactory.newInstance().newXPath().compile(selection);
    NodeList        nodes    = (NodeList) xpath.evaluate(document, XPathConstants.NODESET);

    // Remove all those nodes from the document
    for(int i = 0; i < nodes.getLength(); ++i) {
      Node n = nodes.item(i);
      n.getParentNode().removeChild(n);
    }

    // And finally print the document back into a string.
    StringWriter writer = new StringWriter();
    Transformer  tform  = TransformerFactory.newInstance().newTransformer();

    tform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    tform.transform(new DOMSource(document), new StreamResult(writer));

    // This is our result.
    String processed_xml = writer.getBuffer().toString();

    System.out.println(processed_xml);
  }
}