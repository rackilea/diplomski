import java.io.IOException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.xpath.*;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;

public class AddElementFromProp {

  public static void main(String[] args) 
   throws ParserConfigurationException, SAXException, IOException,
      XPathExpressionException, TransformerException, TransformerConfigurationException {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setNamespaceAware(true); 
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse("demo.xml");
    //The XPath part.
    XPathFactory xfactory = XPathFactory.newInstance();
    XPath xpath = xfactory.newXPath();

    Node result = (Node)xpath.evaluate("/root/*[position()='3']", doc, XPathConstants.NODE);
    Element toInsert = doc.createElement("X");
    result.getParentNode().insertBefore(toInsert, result);
    //////////////////////////////////////////////////////
    result = (Node)xpath.evaluate("/root/*[position()='4']", doc, XPathConstants.NODE);
    toInsert = doc.createElement("Y");
    Text txt = doc.createTextNode("text");
    toInsert.appendChild(txt);
    result.getParentNode().insertBefore(toInsert, result);
    //////////////////////////////////////////////////////
    result = (Node)xpath.evaluate("/root/*[position()='5']", doc, XPathConstants.NODE);
    toInsert = doc.createElement("Z");
    txt = doc.createTextNode("text");
    toInsert.appendChild(txt);
    result.getParentNode().appendChild(toInsert);
    ////////////////////////////////////////////////////////
    result = (Node)xpath.evaluate("/root/X", doc, XPathConstants.NODE); //If you know the name of the node
    //result = (Node)xpath.evaluate("/root/*[position()='3']", doc, XPathConstants.NODE);//If you know the position of the node
    toInsert = doc.createElement("xchild");
    txt = doc.createTextNode("text");
    toInsert.appendChild(txt);
    result.appendChild(toInsert);
    ////////////////////////////////////////////////////////
    // Write out the final xml file
    // Use a Transformer for output
    TransformerFactory tFactory = TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();

    DOMSource source = new DOMSource(doc);
    StreamResult _result = new StreamResult("demo1.xml");
    transformer.transform(source, _result);
  }
}