package forum13166195;

import java.io.StringReader;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.*;

import org.xml.sax.InputSource;

public class XPathDemo {

    public static void main(String[] args) throws Exception{
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                   + "<ns1:schema xmlns:ns1='http://example.com'>"
                       + "<ns1:tag1>"
                           + "<ns1:tag2>value</ns1:tag2>"
                       + "</ns1:tag1>"
                   + "</ns1:schema>";

        XPath xpath = XPathFactory.newInstance().newXPath();
        xpath.setNamespaceContext(new NamespaceContext() {

            public String getNamespaceURI(String arg0) {
                if("a".equals(arg0)) {
                    return "http://example.com";
                }
                return null;
            }

            public String getPrefix(String arg0) {
                return null;
            }

            public Iterator getPrefixes(String arg0) {
                return null;
            }

        });

        InputSource inputSource = new InputSource(new StringReader(xml));
        String result = (String) xpath.evaluate("/a:schema/a:tag1/a:tag2", inputSource, XPathConstants.STRING);
        System.out.println(result);
    }

}