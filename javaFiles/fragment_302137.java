import org.junit.*;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;

import org.w3c.dom.Document;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;

/**
 *
 * @author gpeche
 */
public class SAAJTest {

    @Test 
    public void testAddDocument() throws Exception {
        String xml = "<a><b><c>hello</c><d test='attrib'>foo</d></b>blablabla</a>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));

        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPBody body = message.getSOAPBody();
        body.addDocument(doc);
        message.saveChanges();

        message.writeTo(System.out);
        System.out.println();
    }
}