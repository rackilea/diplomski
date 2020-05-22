import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {
    public static void main(String argv[]) {

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document document = db.parse(new File(
                    "E:/All WorkSpaces in laptop on 02092-14/SelfLearning/Stackoverflow/src/test.xml"));


            NodeList nodeList = document.getElementsByTagName("datapoint");
            for (int x = 0, size = nodeList.getLength(); x < size; x++) {

                if( nodeList.item(x).getParentNode().getParentNode().getAttributes().getNamedItem("protocolName").getNodeValue().contains("BACNET"))
                System.out.println(nodeList.item(x).getAttributes()
                        .getNamedItem("address").getNodeValue()
                        + "\t"
                        + nodeList.item(x).getAttributes()
                                .getNamedItem("programmaticName")
                                .getNodeValue());


            }
            System.out.println("\n");
            NodeList nodeList1 = document.getElementsByTagName("event");
            for (int x1 = 0, size1 = nodeList1.getLength(); x1 < size1; x1++) {
                if( nodeList1.item(x1).getParentNode().getParentNode().getAttributes().getNamedItem("protocolName").getNodeValue().contains("BACNET"))
                System.out.println(nodeList1.item(x1).getAttributes()
                        .getNamedItem("address").getNodeValue()
                        + "\t"
                        + nodeList1.item(x1).getAttributes()
                                .getNamedItem("programmaticName")
                                .getNodeValue());
            }
            System.out.println("\n");
            NodeList nodeList2 = document.getElementsByTagName("command");
            for (int x1 = 0, size1 = nodeList2.getLength(); x1 < size1; x1++) {
                if( nodeList2.item(x1).getParentNode().getParentNode().getAttributes().getNamedItem("protocolName").getNodeValue().contains("BACNET"))
                System.out.println(nodeList2.item(x1).getAttributes()
                        .getNamedItem("address").getNodeValue()
                        + "\t"
                        + nodeList2.item(x1).getAttributes()
                                .getNamedItem("programmaticName")
                                .getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}