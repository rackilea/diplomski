import javax.xml.parsers.*;
import org.apache.xpath.XPathAPI;
import org.w3c.dom.*;

public class TestXPath {

    private static final String CFG_FILE = "test.xml" ;
    private static final String XPATH_FOR_PRM_MaxThread = "/config/param[@id='MaxThread']/text()";

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            docFactory.setNamespaceAware(true);
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document doc = builder.parse(CFG_FILE);
            Node param = XPathAPI.selectSingleNode( doc, XPATH_FOR_PRM_MaxThread );
            if ( param instanceof Text ) {
                System.out.println( Integer.decode(((Text)(param)).getNodeValue() ) ); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}