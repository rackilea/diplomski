import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance(); 
        dFactory.setValidating( false ); 
        DocumentBuilder dBuilder = dFactory.newDocumentBuilder(); 
        Document dDoc = dBuilder.newDocument(); 

        // The root document element. 
        Element pageDataElement = dDoc.createElement("page-data"); 
        pageDataElement.appendChild(dDoc.createTextNode("Example Text.")); 

        dDoc.appendChild(pageDataElement); 

        System.out.println(dDoc.getDocumentElement().getTextContent());
    }
}