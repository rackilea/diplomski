import java.io.StringReader;
import java.util.Collections;
import java.util.Iterator;
import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;

public class XPathTest {
    public static void main(String[] args) throws Exception {
        String source = "<nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"2.00\"></nfeProc>";

        try {
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();

            NamespaceContext context = new NamespaceContext() {
                private static final String PREFIX = "nfe";
                private static final String URI = "http://www.portalfiscal.inf.br/nfe";

                @Override
                public String getNamespaceURI(String prefix) {
                    return (PREFIX.equals(prefix)) ? URI : XMLConstants.NULL_NS_URI;
                }

                @Override
                public String getPrefix(String namespaceUri) {
                    return (URI.equals(namespaceUri)) ? PREFIX : XMLConstants.DEFAULT_NS_PREFIX;
                }

                @Override
                public Iterator getPrefixes(String namespaceUri) {
                    return Collections.singletonList(this.getPrefix(namespaceUri)).iterator();
                }
            };

            xPath.setNamespaceContext(context);

            InputSource inputSource = new InputSource(new StringReader(source));
            String versao = xPath.evaluate("//nfe:nfeProc/@versao", inputSource);

            System.out.println(versao.toString());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
    }
}