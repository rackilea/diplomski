import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XPathNamespaceExample {
    static public class MyNamespaceContext implements NamespaceContext {
        final private Map<String, String> prefixMap;
        MyNamespaceContext(Map<String, String> prefixMap)
        {
            if (prefixMap != null)
            {
                this.prefixMap = Collections.unmodifiableMap(new HashMap<String, String>(prefixMap));
            }
            else
            {
                this.prefixMap = Collections.emptyMap();
            }
        }
        public String getPrefix(String namespaceURI) {
            // TODO Auto-generated method stub
            return null;
        }
        public Iterator getPrefixes(String namespaceURI) {
            // TODO Auto-generated method stub
            return null;
        }
        public String getNamespaceURI(String prefix) {
                if (prefix == null) throw new NullPointerException("Invalid Namespace Prefix");
                else if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX))
                    return "http://www.PureEdge.com/XFDL/6.5";
                else if ("custom".equals(prefix))
                    return "http://www.PureEdge.com/XFDL/Custom";
                else if ("designer".equals(prefix)) 
                    return "http://www.PureEdge.com/Designer/6.1";
                else if ("pecs".equals(prefix)) 
                    return "http://www.PureEdge.com/PECustomerService";
                else if ("xfdl".equals(prefix))
                    return "http://www.PureEdge.com/XFDL/6.5";      
                else if ("xforms".equals(prefix)) 
                    return "http://www.w3.org/2003/xforms";
                else    
                    return XMLConstants.NULL_NS_URI;
        }


    }

    protected static final String QUERY_FORM_NUMBER = 
        "/XFDL/globalpage/global/xmlmodel/xforms:instances/instance" + 
        "/form_metadata/title/documentnbr[number]";

    public static void main(String[] args) {
        try
        {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(args[0]));
            System.out.println(extractNodeValue(doc, "/XFDL/globalpage/@sid"));
            System.out.println(extractNodeValue(doc, "/XFDL/globalpage/global/xmlmodel/instances/instance/@id" ));
            System.out.println(extractNodeValue(doc, "/XFDL/globalpage/global/xmlmodel/instances/instance/form_metadata/title/documentnbr/@number" ));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static String extractNodeValue(Document doc, String expression) {
        try{

            XPath xPath = XPathFactory.newInstance().newXPath();
            xPath.setNamespaceContext(new MyNamespaceContext(null));

            Node result = (Node)xPath.evaluate(expression, doc, XPathConstants.NODE);
            if(result != null) {
                return result.getNodeValue();
            } else {
                throw new RuntimeException("can't find expression");
            }

        } catch (XPathExpressionException err) {
            throw new RuntimeException(err);
        }
    }
}