package xml;

import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class QueryXmlFileDemo {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sportcars.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document inputDocument = dBuilder.parse(inputFile);
            inputDocument.getDocumentElement().normalize();
            Node carsNode = inputDocument.getFirstChild();
            NodeList carsNodeList = carsNode.getChildNodes();
            for (int i = 0; i < carsNodeList.getLength(); i++) {
                Node carTypes = carsNodeList.item(i);
                // hides the #text-entries
                if (Node.ELEMENT_NODE != carTypes.getNodeType()) {
                    continue;
                }
                System.out.println("CarType: " + carTypes.getNodeName());
            }
        } catch (Exception e) {
        }
    }
}