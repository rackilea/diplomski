import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Transformation 
{
  private static final XPath XPATH = XPathFactory.newInstance().newXPath();

  public static void main(String[] args) 
  {
    try 
    {
      DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

      Document xml1 = documentBuilder.parse(new ByteArrayInputStream("<Field name=\"topmostSubform[0].Page[0].MemberID[0]\" value=\"1\"/>".getBytes()));
      Document xml2 = documentBuilder.parse(new ByteArrayInputStream("<Field name=\"topmostSubform[0].Page[0].MemberID[1]\" value=\"2\"/>".getBytes()));
      Document xml3 = documentBuilder.parse(new ByteArrayInputStream("<Field name=\"topmostSubform[0].Page[1].MemberID[0]\" value=\"3\"/>".getBytes()));
      Document xml4 = documentBuilder.parse(new ByteArrayInputStream("<Field name=\"topmostSubform[1].Page[0].MemberID[0]\" value=\"4\"/>".getBytes()));

      Document document = documentBuilder.newDocument();
      document.appendChild(document.createElement("root"));

      //Loop through each piece of XML creating elements in the single document as necessary.
      for (Document xml : new Document[]{xml1, xml2, xml3, xml4}) 
      {
        Element fieldElement = (Element)XPATH.evaluate("/Field", xml, XPathConstants.NODE);

        String name = fieldElement.getAttribute("name");
        String value = fieldElement.getAttribute("value");

        createElements(
          document, 
          document.getDocumentElement(), 
          new ArrayList<String>(Arrays.asList(name.split("\\."))), 
          value
        );
      }

      //Print the result at the command line.
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

      StringWriter writer = new StringWriter();
      transformer.transform(new DOMSource(document), new StreamResult(writer));

      System.out.println(writer.getBuffer().toString());
    }
    catch (Exception e) 
    {
      e.printStackTrace();
    }
  }

  /**
   * Creates child elements under the <code>parent</code> based on the <code>nameTokens</code>.
   */
  private static void createElements(Document document, Element parent, List<String> nameTokens, String value) throws XPathExpressionException 
  {
    String nameToken = nameTokens.remove(0);

    String name = nameToken.substring(0, nameToken.indexOf("["));
    String index = nameToken.substring(nameToken.indexOf("[") + 1, nameToken.indexOf("]"));

    Element element = (Element)XPATH.evaluate(name + "[@ind=" + index + "]", parent, XPathConstants.NODE);
    if (element == null) 
    {
      element = document.createElement(name);
      element.setAttribute("ind", index);
      parent.appendChild(element);
    }

    if (nameTokens.isEmpty()) 
    {
      element.appendChild(document.createTextNode(value));
    }
    else 
    {
      createElements(document, element, nameTokens, value);
    }
  }
}