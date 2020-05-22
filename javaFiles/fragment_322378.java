import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StaxExample {

    public static class CustomSAXHandler extends DefaultHandler {

        private String senderId;

        private final List<String> attachmentIds = new ArrayList<>();

        private StringBuffer currentCharacters = new StringBuffer();

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (currentCharacters != null) {
                currentCharacters.append(String.valueOf(ch, start, length));
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes)
                throws SAXException {
            currentCharacters = new StringBuffer();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            switch (localName) {
            case "AttachmentID":
                getAttachmentIds().add(currentCharacters.toString());
                break;
            case "SenderID":
                setSenderId(currentCharacters.toString());
                break;
            }
            currentCharacters = null;
        }

        public String getSenderId() {
            return senderId;
        }

        public void setSenderId(String senderId) {
            this.senderId = senderId;
        }

        public List<String> getAttachmentIds() {
            return attachmentIds;
        }

    }

    public static void main(String[] args) throws XMLStreamException, SAXException, IOException, ParserConfigurationException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        SAXParser saxParser = factory.newSAXParser();
        CustomSAXHandler saxHandler = new CustomSAXHandler();
        saxParser.parse(StaxExample.class.getResourceAsStream("test.xml"), saxHandler); 
        System.out.println("SenderID: " + saxHandler.getSenderId());
        System.out.println("AttachmentIDs: " + saxHandler.getAttachmentIds());
    }

}