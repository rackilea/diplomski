import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Test
{

    public static void main(String[] args)
    {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(
                    "<eMail><to>Tove</to><from>Jani</from><heading>Reminder</heading><body>Don't forget me this weekend!</body></eMail> ")));
            NodeList firstEle = document.getElementsByTagName("eMail");
            for (int i = 0; i < firstEle.getLength(); i++)
            {
                Node node = firstEle.item(i); // email
                System.out.println("\ncurrent element : " + node.getNodeName()); // print email
                NodeList allEmailChilds = node.getChildNodes();
                System.out.print("num of child nodes : " + allEmailChilds.getLength());// print 47
                for (int j = 0; j < allEmailChilds.getLength(); j++)
                {
                    Node inMail = allEmailChilds.item(j);
                    System.out.print("email element - " + inMail.getNodeName()); // prints #text

                    System.out.print("email value - " + inMail.getTextContent()); // prints empty line
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}