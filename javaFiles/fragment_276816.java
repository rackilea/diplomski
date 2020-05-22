import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();

        InputSource xml = new InputSource("input.xml");
        NodeList leafNodeObjects = (NodeList) xp.evaluate("//*[not(*)]", xml, XPathConstants.NODESET);

        for(int x=0; x<leafNodeObjects.getLength(); x++) {
            System.out.print("nodeElement = ");
            System.out.print(leafNodeObjects.item(x).getNodeName());
            System.out.print(" and node value = ");
            System.out.println(leafNodeObjects.item(x).getTextContent());
        }
    }

}