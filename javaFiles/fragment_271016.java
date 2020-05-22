import java.io.StringReader;
import javax.xml.xpath.*;
import org.xml.sax.*;

public class Demo {

    private static String XML = "<APP START='2014-08-25 13:45:58' SINCE='2014-08-25 13:45:58' STATE='Running' NAME='abc' ID='4305' Codebase='www.domain.com' Build-Revision='3d6ca1de3ce6d9832bc314356e54038bb8cab342' Build-Path='UNKNOWN' Build-Label='128.3' Build-Date='2014-08-16 20:03:34' Permissions='all-permissions'><Runtime NUM_PROCESSORS='12' TOTAL_MEMORY='8588886016' MAX_MEMORY='8588886016' FREE_MEMORY='4902842840'/></APP>";

    public static void main(String[] args) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        InputSource xml = new InputSource(new StringReader(XML));
        String result = (String) xpath.evaluate("//@Build-Label", xml, XPathConstants.STRING);
        System.out.println(result);
    }

}