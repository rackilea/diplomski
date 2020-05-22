import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Example {

    public static void main(String[] args) {
    File f = new File("test.xml");
    try {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new FileInputStream(f));

        NodeList nodes = doc.getElementsByTagName("FLIGHT");
        for (int i = 0; i < nodes.getLength(); i++) {
        Element element = (Element) nodes.item(i);
        String airport = element.getAttribute("airport");

        System.out.println("element " + i + ": airport='" + airport + "'");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}