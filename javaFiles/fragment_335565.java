import java.io.StringReader;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseInBoundSoapMessage {

    private static InBoundSoapMessage inBoundSoapMessage=null;


    public static InBoundSoapMessage getInBoundSoapMessage(String xml) {
        try {
            inBoundSoapMessage=new InBoundSoapMessage();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setNamespaceAware(true);
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                boolean ischargeBoxIdentityPresent = false;
                boolean isAddressPresent = false;
                boolean isFromPresent=false;
                boolean isActionPresent=false;
                boolean isMessageID=false;
                boolean isRelatesTo=false;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (localName.equals("chargeBoxIdentity")) {
                        ischargeBoxIdentityPresent = true;
                    }
                    if (localName.equals("From")) {
                        isFromPresent = true;
                    }
                    if (localName.equals("Address")) {
                        isAddressPresent = true;
                    }
                    if(localName.equals("Action")){
                        isActionPresent=true;
                    }
                    if(localName.equals("MessageID")){
                        isMessageID=true;
                    }
                    if(localName.equals("RelatesTo")){
                        isRelatesTo=true;
                    }

                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (ischargeBoxIdentityPresent) {
                        inBoundSoapMessage.setChargeBoxIdentity(new String(ch, start, length));
                        ischargeBoxIdentityPresent = false;
                    }
                    if(isAddressPresent && isFromPresent){
                        inBoundSoapMessage.setAddressInFrom(new String(ch, start, length));
                        isAddressPresent = false;
                        isFromPresent=false;
                    }
                    if(isActionPresent){
                        inBoundSoapMessage.setAction(new String(ch, start, length));
                        isActionPresent=false;
                    }
                    if(isMessageID){
                        inBoundSoapMessage.setMessageId(new String(ch, start, length));
                        isMessageID=false;
                    }
                    if(isRelatesTo){
                        inBoundSoapMessage.setRelatesTo(new String(ch, start, length));
                        isRelatesTo=false;
                    }
                }
            };
            saxParser.parse(new InputSource(new StringReader(xml)), handler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inBoundSoapMessage;
    }
}