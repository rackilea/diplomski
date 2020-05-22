import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class SAXDemo {

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        xr.setContentHandler(new DefaultHandler() {

            @Override
            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                String string = new String(ch, start, length);
                if(string.contains("<")) {
                    System.out.println(string);
                }
            }}
       );

       xr.parse("ressources/messages001.xml");
    }

}