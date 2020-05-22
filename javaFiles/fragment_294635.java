import java.util.*;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NsContentHandler extends DefaultHandler {

    private Map<String, String> namespaces = new TreeMap<String, String>();

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        if(!namespaces.containsKey(prefix)) {
            namespaces.put(prefix, uri);
        }
    }

    public Map<String, String> getNamespaces() {
        return namespaces;
    }

}