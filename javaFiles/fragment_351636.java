import java.io.File;
import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class TestXPath {

    private static final String CFG_FILE = "test.xml" ;
    private static final String XPATH_FOR_PRM_MaxThread = "/config/param[@id='MaxThread']/text()";

    public static void main(String[] args) {
        try {
            SAXBuilder sxb = new SAXBuilder();
            Document doc = sxb.build(new File(CFG_FILE));
            Element root = doc.getRootElement();
            XPath xpath = XPath.newInstance(XPATH_FOR_PRM_MaxThread);
            Text param = (Text) xpath.selectSingleNode(root);
            Integer maxThread = Integer.decode( param.getText() );
            System.out.println( maxThread );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}