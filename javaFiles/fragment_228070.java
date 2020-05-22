import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParsarDemo {
    protected DocumentBuilder docBuilder;
    protected Element root;

    public DOMParsarDemo() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        docBuilder = dbf.newDocumentBuilder();
    }

    public void parse(String file) throws Exception {
        Document doc = docBuilder.parse(new FileInputStream(file));
        root = doc.getDocumentElement();
        System.out.println("root element is :" + root.getNodeName());
    }

    public void printAllElements() throws Exception {
        printElement(root);
    }

    public void printElement(Node node) {
        if (node.getNodeType() != Node.TEXT_NODE) {
            Node child = node.getFirstChild();
            while (child != null) {
                if (node.getNodeName().equals("distance")) {
                    if (child.getNodeName().equals("value")) {
                        System.out.println(child.getFirstChild().getNodeValue());
                    }
                }
                printElement(child);
                child = child.getNextSibling();
            }
        }
    }

    public static void main(String args[]) throws Exception {
        DOMParsarDemo demo = new DOMParsarDemo();
        demo.parse("resources/abc.xml");
        demo.printAllElements();
    }
}