import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author JayaPrasad
 * 
 */
public class ParseXml {

    private String paramReader(String tag) {

        String value = "";
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse("parse.xml");

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("parameter");

            for (int i = 0; i < nList.getLength(); i++) {

                Node nNode = nList.item(i);
//              NodeList childNodes = nNode.getChildNodes();
//              for (int j = 0, length = childNodes.getLength(); j < length; j++) {
                // System.out.println(childNodes.item(j).getNodeName() + ":"
//                   + childNodes.item(j).getTextContent());
//                  if (childNodes.item(j).getNodeName().equals(tag)) {
//                      value = childNodes.item(j).getTextContent();
//                       System.out.println("Tag Node Value ::: " + value);
//                  }
//              }

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = null;
                    if (nNode instanceof Element) { // Safest way before casting
                        eElement = (Element) nNode;
                    }

                    if (eElement.getElementsByTagName("tag").item(0)
                            .getTextContent().trim().equals(tag)) {

                        value = eElement.getElementsByTagName("value").item(0)
                                .getTextContent();
                        System.out.println("Result value :: " + value);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;

    }

    public static void main(String[] args) {
        ParseXml xmlObj = new ParseXml();
        xmlObj.paramReader("Call_time");
    }

}