import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class LearninXmlDoc
{
    private static String getTagValue(final Element element)
    {
        System.out.println(element.getTagName() + " has attributes: " + element.hasAttributes());

        if (element.getTagName().startsWith("test"))
        {
            return element.getAttribute("w");

        }
        else
        {
            return element.getNodeValue();
        }
    }

    public static void main(String[] args)
    {
        final String fileName = "c:\\tmp\\test\\domXml.xml";

        readXML(fileName);
    }

    private static void readXML(String fileName)
    {
        Document document;
        DocumentBuilder documentBuilder;
        DocumentBuilderFactory documentBuilderFactory;
        NodeList nodeList;
        File xmlInputFile;

        try
        {
            xmlInputFile = new File(fileName);
            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(xmlInputFile);
            nodeList = document.getElementsByTagName("*");

            document.getDocumentElement().normalize();

            for (int index = 0; index < nodeList.getLength(); index++)
            {
                Node node = nodeList.item(index);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;

                    System.out.println("\tcolour : " + getTagValue(element));
                    System.out.println("\ttest : " + getTagValue(element));
                    System.out.println("-----");
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}