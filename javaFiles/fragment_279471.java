import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX2 {

    public static void main(String[] args) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(new File("test.xml"), new DefaultHandler() {

            @Override
            public void startElement(String uri, String localName,
                    String qName, Attributes atts) throws SAXException {
                if (qName.equals("passenger")) {
                    System.out.println("id = " + atts.getValue(0));
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
            }

            @Override
            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                String text = new String(ch, start, length);
                if (!text.trim().isEmpty()) {
                    System.out.println("name " + text);
                }
            }
        });
    }
}