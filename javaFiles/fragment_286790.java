import java.io.StringReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        String docroot = "<div><i>items <b>sold</b></i></div>";
        XPath xxpath = XPathFactory.newInstance().newXPath();
        InputSource inputSource = new InputSource(new StringReader(docroot)); 
        String result = (String) xxpath.evaluate("//b", inputSource, XPathConstants.STRING);
        System.out.println(result);
    }

}