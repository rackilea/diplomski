import org.xml.sax.*;
import org.xml.sax.helpers.*;
import javax.xml.parsers.*;

....

InputStream in = connection.getInputStream();

InputSource responseXML = new InputSource(in);
final StringBuilder response = new StringBuilder();
DefaultHandler myHandler = new DefaultHandler() {

    public void startElement(String uri, String localName, String qName, 
            Attributes attributes) throws SAXException {
        if (localName.equals("elementname")) {
            response.append(attributes.getValue("attributename"));
            inElement = true;
        }
    }
    public void characters(char [] buf, int offset, int len) {
        if (inElement) {
            inElement = false;
            String s = new String(buf, offset, len);
            response.append(s);
            response.append("\n");
        }
    }
};

SAXParserFactory factory = SAXParserFactory.newInstance();
try {
    SAXParser parser = factory.newSAXParser();
    parser.parse(responseXML, myHandler);
} catch (ParserConfigurationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (SAXException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}

in.close();
connection.disconnect();

....