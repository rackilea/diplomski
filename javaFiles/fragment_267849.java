import java.util.HashMap;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MyContentHandler implements ContentHandler {

    private HashMap<String, Object> feed;
    private HashMap<String, Object> peroidContent;
    private HashMap<String, Object> callContent;
    private HashMap<String, Object> callsMap;
    private HashMap<String, Object> lineContent;
    private HashMap<String, Object> linesMap;

    private String text;
    private String callId;
    private String lineId;

    @Override
    public void startDocument() throws SAXException {
        /* You can perform some action in this method
         * for example to reset some sort of Collection
         * or any other variable you want. It gets called
         * every time a document starts. */
        feed = new HashMap<String, Object>();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        // Gets called every time an opening tag is encountered.
        if(localName.equalsIgnoreCase("FEED")) {
            /* We've found a "feed" opening tag so we capture its
             * version attribute and put it into our HashMap.*/
            feed.put("Version", atts.getValue("version"));
        } else if(localName.equalsIgnoreCase("PEROID")) {
            peroidContent = new HashMap<String, Object>();
            peroidContent.put("From", atts.getValue("from"));
            peroidContent.put("to", atts.getValue("to"));
        } else if(localName.equalsIgnoreCase("LINE")) {
            linesMap = new HashMap<String, Object>();
        } else if(localName.equalsIgnoreCase("LINE")) {
            lineContent = new HashMap<String, Object>();
            lineId = atts.getValue("id");
            lineContent.put("name", atts.getValue("name"));
            lineContent.put("shortname", atts.getValue("shortname"));
            lineContent.put("status", atts.getValue("status"));
        } else if(localName.equalsIgnoreCase("CALLS")) {
            callsMap = new HashMap<String, Object>();
        } else if(localName.equalsIgnoreCase("CALL")) {
            callContent = new HashMap<String, Object>();
            callId = atts.getValue("Id");
            callContent.put("created", atts.getValue("created"));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        /* Gets called every time in between an opening tag and
         * a closing tag if characters are encountered. */
        text = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        // Gets called every time a closing tag is encountered.
        if(localName.equalsIgnoreCase("FEED")) {
            feed.put("Peroid", peroidContent);
        } else if(localName.equalsIgnoreCase("PEROID")) {
            peroidContent.put("Lines", linesMap);
        } else if(localName.equalsIgnoreCase("LINES")) {
            linesMap.put(lineId, lineContent);
        } else if(localName.equalsIgnoreCase("LINE")) {
            lineContent.put("Calls", callsMap);
        } else if(localName.equalsIgnoreCase("CALLS")) {
            callsMap.put(callId, callContent);
        } else if(localName.equalsIgnoreCase("BOOKING")) {
            callContent.put("Booking", text.toString());
        }
    }

    @Override
    public void endDocument() throws SAXException {
        /* You can perform some action in this method
         * for example to reset some sort of Collection
         * or any other variable you want. It gets called
         * every time a document end is reached. */
        SAXParsingFun.setHashMap(feed);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void processingInstruction(String target, String data)
            throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        // TODO Auto-generated method stub
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        // TODO Auto-generated method stub
    }

    @Override
    public void startPrefixMapping(String prefix, String uri)
            throws SAXException {
        // TODO Auto-generated method stub
    }
}