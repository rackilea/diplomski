package forum11578831;

import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document dDoc = builder.parse("src/forum11578831/input.xml");

        XPath xPath = XPathFactory.newInstance().newXPath();
        String string = (String) xPath.evaluate("/documents/document/element[@name='doctype']/value", dDoc, XPathConstants.STRING);
        System.out.println(string);
    }

}