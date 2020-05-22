import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public XMLDoc()
    {
        try
        {
            File xmlFile = new File("C:\\my_file.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = _doc.getElementsByTagName("row");
            for (int i = 0; i < nList.getLength(); i++)
            {
                Node nNode = nList.item(i);

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    Node itemNode = eElement.getElementsByTagName("FILE_NAME").item(0);
                    String text = itemNode != null ? itemNode.getTextContent() : "";

                    // russian text is fine here
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }