import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.NamespaceSupport;

import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParserFactory;

/**
 * @author Santhosh Kumar Tekuri
 */
public class XSIHandler extends DefaultHandler{
    private boolean needNewContext;
    private NamespaceSupport nsSupport;

    @Override
    public void startDocument() throws SAXException{
        nsSupport = new NamespaceSupport();
        needNewContext = true;
        super.startDocument();
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException{
        if(needNewContext){
            nsSupport.pushContext();
            needNewContext = false;
        }
        nsSupport.declarePrefix(prefix, uri);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException{
        if(needNewContext)
            nsSupport.pushContext();
        needNewContext = true;
        String xsiType = atts.getValue(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "type");
        if(xsiType!=null){
            String prefix, suffix;
            int colon = xsiType.indexOf(':');
            if(colon==-1){
                prefix = "";
                suffix = xsiType;
            }else{
                prefix = xsiType.substring(0, colon);
                suffix = xsiType.substring(colon+1);
            }
            System.out.println("xsi:type for " + qName + " is uri: " + nsSupport.getURI(prefix) + " localName: " + suffix);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        nsSupport.popContext();
    }
}