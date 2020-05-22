import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Test{

public static void main (String[] args)
{
    Test test = new Test();
    test.readXML();
}

private void readXML()
{
    Document doc = null;
    try 
    {
        doc = parseXML("/home/abc/Test.xml");
    } 
    catch (ParserConfigurationException e) 
    {
        e.printStackTrace();
    } 
    catch (SAXException e) 
    {
        e.printStackTrace();
    } 
    catch (IOException e) 
    {
        e.printStackTrace();
    }

    if(doc != null)
    {
        NodeList nList = doc.getElementsByTagName("item_list");
        for (int i = 0; i < nList.getLength(); i++) 
        {
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;
            Element cElement =  (Element) eElement.getElementsByTagName("manager").item(0);
            System.out.println("Manager ID : " + cElement.getAttribute("person"));
        }
    }
}

private Document parseXML(String filePath) throws ParserConfigurationException, SAXException, IOException
{
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(filePath);
    doc.getDocumentElement().normalize();
    return doc;
}
}