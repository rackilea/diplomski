import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SOAPMessageTest {

    public static void main(String[] args) throws Exception {

        // create message factory
        MessageFactory mf = MessageFactory.newInstance();
        // headers for a SOAP message
        MimeHeaders header = new MimeHeaders();     
        header.addHeader("Content-Type", "text/xml");

        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"+
         "<soapenv:Body>"+
           "<theRequest>"+
             "<username>user</username>"+
             "<password>password</password>"+
             "<someMsg>sooomeMessage</someMsg>"+
           "</theRequest>"+
          "</soapenv:Body>"+
        "</soapenv:Envelope>";
        InputStream is = new ByteArrayInputStream(request.getBytes());

        // create the SOAPMessage
        SOAPMessage soapMessage = mf.createMessage(header,is);
        // get the body
        SOAPBody soapBody = soapMessage.getSOAPBody();
        // find your node based on tag name
        NodeList nodes = soapBody.getElementsByTagName("someMsg");
        System.out.println(nodes.getClass().getName());
        // check if the node exists and get the value
        String someMsgContent = null;
        Node node = nodes.item(0);
        someMsgContent = node != null ? node.getTextContent() : "";

        System.out.println(someMsgContent);
    }
}