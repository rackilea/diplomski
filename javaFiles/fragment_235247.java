import java.io.StringReader;
import java.util.Arrays;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Q26897496 extends DefaultHandler {

    public static String xmlDoc = "<?xml version='1.0'?>"   
            + "<properties>"
            + "   <definition>" 
            + "      <name>IP</name>"  
            + "      <description></description>"
            + "      <defaultValue>10.1.1.1</defaultValue>"
            + "   </definition>" 
            + "   <definition>"
            + "      <name>Name</name>" 
            + "      <description></description>"
            + "      <defaultValue>MyName</defaultValue>" 
            + "   </definition>"
            + "   <definition>" 
            + "      <name>Environment</name>"
            + "      <description></description>"
            + "      <defaultValue>Production</defaultValue>"
            + "   </definition>" 
            + "</properties>";


    String elementName;
    boolean mark = false;
    char[] updatedDoc;

    public static void main(String[] args) {

        Q26897496 q = new Q26897496();
        try {
            q.parse();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Q26897496() {

    }

    public void parse() throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xml = saxParser.getXMLReader();
        xml.setContentHandler(this);
        xml.parse(new InputSource(new StringReader(xmlDoc)));

        System.out.println("new xml: \n" + new String(updatedDoc));
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("starting");

    }

    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
        this.elementName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String value = new String(ch).substring(start, start + length);
        if (elementName.equals("name")) {
            if (value.equals("Environment")) {
                this.mark = true;
            }
        }

        if (elementName.equals("defaultValue") && mark == true) {
            // update
            String tmpDoc = new String(ch);
            String leading = tmpDoc.substring(0, start);
            String trailing = tmpDoc.substring(start + length, tmpDoc.length());
            this.updatedDoc = (leading + "NewValueForDefaulValue" + trailing).toCharArray();
            mark = false;
        }
    }
}