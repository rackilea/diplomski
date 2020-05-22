package test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sun.org.apache.xerces.internal.dom.DeferredElementImpl;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xmlmx {

    public static void main(String[] args) {
        ArrayList<Anime> list = new ArrayList<Anime>();
        try {
            File inputFile = new File("test.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            Node recordNode = null;
            NodeList childNodes = doc.getFirstChild().getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeName().equals("record")) {
                    recordNode = childNodes.item(i);
                    break;
                }
            }
            System.out.println("----------------------------");


            Map<String, String> map = new HashMap<>();
            if (recordNode != null) {
                NodeList subNodes = recordNode.getChildNodes();
                for (int i = 0; i < subNodes.getLength(); i++) {
                    if (subNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        map.put(subNodes.item(i).getNodeName(), subNodes.item(i).getTextContent());
                    }
                }
            }

            String id = ((DeferredElementImpl) recordNode).getAttribute("ID");
            list.add(new Anime(id,
                    map.get("name"),
                    map.get("altname"),
                    map.get("seasons"),
                    map.get("episodes"),
                    map.get("status"),
                    map.get("DS"),
                    map.get("have"),
                    map.get("left"),
                    map.get("plot"),
                    map.get("connect"),
                    map.get("image")));

            System.out.println(list.get(0));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}