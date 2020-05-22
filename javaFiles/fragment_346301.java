import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EnterExitListener {

    static Node e = null;

    public static void main(String[] argd) {
        String arrayOfErrorContext = "<root><item><errorCode>1</errorCode><errorDescription></errorDescription></item><item><errorCode>1</errorCode><errorDescription></errorDescription></item></root>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(
                    arrayOfErrorContext)));
            NodeList nList1 = document.getElementsByTagName("root");
            int i = nList1.getLength();

            e = nList1.item(0).getFirstChild();
            e.getChildNodes();
            recurseNode(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void recurseNode(Node node) {
        System.out.println(node.getNodeName() + node.getTextContent());

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // calls this method for all the children which is Element
                recurseNode(currentNode);
            }
        }

    }
}