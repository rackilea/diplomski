import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;

public class TestXPath {

    private static final String CFG_FILE = "test.xml" ;
    private static final String XPATH_FOR_PRM_MaxThread = "/config/param[@id='MaxThread']/text()";
    public static void main(String[] args) {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        try {
            builder = docFactory.newDocumentBuilder();
            Document doc = builder.parse(CFG_FILE);
            XPathExpression expr = XPathFactory.newInstance().newXPath().compile(XPATH_FOR_PRM_MaxThread);
            Object result = expr.evaluate(doc, XPathConstants.NUMBER);
            if ( result instanceof Double ) {
                System.out.println( ((Double)result).intValue() );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}