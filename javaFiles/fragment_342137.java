import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import searchexperiment.Paths;
public class DocBuilderClass implements Paths
{

public static String[] username() 
{
    String[] SearchElements=new String[4];
    try
    {
        FileInputStream file = new FileInputStream(new File(test_xml));

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder =  builderFactory.newDocumentBuilder();
         Document xmlDocument = builder.parse(file);

        XPath xPath =  XPathFactory.newInstance().newXPath();

        System.out.println("*************************");
        String expression="/SearchStrings/Search/Tips";
        System.out.println("This is ordered expression \n"+expression);
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);
        //int size=
        for(int i=0;i< nodeList.getLength();i++)
        {
             // Node nNode = emailNodeElementList.item(j);
            //  Element eElement = (Element) nNode;
            System.out.println("Taking the loop value");
            //Object array = push(SearchStrings[i],nodeList.item(i).getFirstChild().getNodeValue());
              String text=nodeList.item(i).getFirstChild().getNodeValue();  
              //googlebox.clear();
             // googlebox.sendKeys(text);
              SearchElements[i]=text;
              System.out.println("Closing the loop value");

        }

    }
    catch(Exception ex)
    {
    System.out.println("This is a exception" + ex);
    }
    finally
    {

    }
    return SearchElements;

}   
}