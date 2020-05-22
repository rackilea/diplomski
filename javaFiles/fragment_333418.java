import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class XmlChange {

    public static void main(String argv[]) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type like textToFind,textToReplace: "); // type, for example CEO,Chief Executive Officer
        String next = keyboard.nextLine();

        String[] input = next.split(",");

        String textToFind = input[0].replace("'", "\\'"); //"CEO";
        String textToReplace = input[1].replace("'", "\\'"); // "Chief Executive Officer";
        String filepath = "root.xml";
        String fileToBeSaved = "root2.xml";

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filepath);

        XPath xpath = XPathFactory.newInstance().newXPath();
        // change ELEMENTS


        String xPathExpression = "//*[text()='" + textToFind + "']";
        NodeList nodes = (NodeList) xpath.evaluate(xPathExpression, doc, XPathConstants.NODESET);

        for (int idx = 0; idx < nodes.getLength(); idx++) {
            nodes.item(idx).setTextContent(textToReplace);
        }

        // change ATTRIBUTES
        String xPathExpressionAttr = "//*/@*[.='" + textToFind + "']";
        NodeList nodesAttr = (NodeList) xpath.evaluate(xPathExpressionAttr, doc, XPathConstants.NODESET);

        for(int i=0; i<nodesAttr.getLength(); i++) {
            nodesAttr.item(i).setTextContent(textToReplace);
        }
        System.out.println("Everything replaced.");

        // save xml file back
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(fileToBeSaved));
        transformer.transform(source, result);
    }
}