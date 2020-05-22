import java.io.File;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxSample {

    public static void main(String argv[]) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                StringBuilder value;

                public void startElement(String uri, String localName,
                        String qName, Attributes attributes)
                        throws SAXException {
                    value = new StringBuilder();
                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {
                    if ("fileContent".equalsIgnoreCase(qName)) {
                        String decodedValue = new String(DatatypeConverter.parseBase64Binary(value.toString()));
                        System.out.println(qName + " = " + decodedValue);
                    } else {
                        System.out.println(qName + " = " + value);
                    }
                    value = new StringBuilder();
                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {
                    value.append(new String(ch, start, length));
                }

            };

            saxParser.parse(new File("data.xml"), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}