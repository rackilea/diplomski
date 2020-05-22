import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import org.xml.sax.InputSource;
import java.net.*;

public class test
{
    public static void main(String[] args) throws Exception
    {
    URL url = new URL("http://pastebin.com/raw.php?i=RF8cL5YZ");
    InputSource xml = new InputSource(url.openStream());
    String name = "Ed";

    XPath xpath = XPathFactory.newInstance().newXPath();
    String expr = String.format("//a/b/c[@name2='%s']", name);
    Node c = null;
    try {
        c = (Node) xpath.evaluate(expr, xml, XPathConstants.NODE);
    } catch (XPathExpressionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    NamedNodeMap attribs = c.getAttributes();
    String id = attribs.getNamedItem("id").getNodeValue();
    String time = attribs.getNamedItem("time").getNodeValue();
    // etc.

    System.out.println("["+String.valueOf(id)+"]["+String.valueOf(time)+"]");
    }
}