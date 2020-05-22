import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Demo {

    public static void main(String[] args) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document dDoc = builder.parse("E:/test.xml");

            XPath xPath = XPathFactory.newInstance().newXPath();
            NodeList nl = (NodeList) xPath.evaluate("/root/author", dDoc, XPathConstants.NODESET);
            System.out.println(nl.getLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}