package forum13166195;

import java.io.StringReader;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class DomDemo {

    public static void main(String[] args) throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                   + "<ns1:schema xmlns:ns1='http://example.com'>"
                       + "<ns1:tag1>"
                           + "<ns1:tag2>value</ns1:tag2>"
                       + "</ns1:tag1>"
                   + "</ns1:schema>";

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(new InputSource(new StringReader(xml))); 

        NodeList nl = doc.getElementsByTagNameNS("http://example.com", "tag2");

        String a = nl.item(0).getTextContent();
        System.out.println(a);
    }

}