import java.io.*;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;

public class ReadKml {
    public static void main(String args[]) throws Exception {
        File kmlFile = new File("test.kml");
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(kmlFile);

        XPath xPath = XPath.newInstance("//k:kml/k:Document/k:Placemark/k:LookAt");
        xPath.addNamespace("k", document.getRootElement().getNamespaceURI());

        Element node = (Element) xPath.selectSingleNode(document.getRootElement());
        System.out.println(node.getName());
    }
}