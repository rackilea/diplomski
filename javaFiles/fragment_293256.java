import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLTest { 
    @Test
    public void testXmlParsing() throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("/Users/aakture/Documents/workspace-sts-2.9.1.RELEASE/smartfox/branches/trunk/java/gelato/src/test/resources/sample.xml").getAbsolutePath());
        Node poItem = doc.getElementsByTagName("POITEM").item(0);
        NodeList poItemChildren = poItem.getChildNodes();
        for (int i = 0; i < poItemChildren.getLength(); i++) {
            Node item = poItemChildren.item(i);
            NodeList itemChildren = item.getChildNodes();
            for (int j = 0; j < itemChildren.getLength(); j++) {
                Node itemChild = itemChildren.item(j);
                if("PO_ITEM".equals(itemChild.getNodeName())) {
                    System.out.println("found PO_ITEM: " +     itemChild.getTextContent());
                }
                if("MATL_GROUP".equals(itemChild.getNodeName())) {
                    System.out.println("found MATL_GROUP: " + itemChild.getTextContent());
                }

            }
        }
    }
}