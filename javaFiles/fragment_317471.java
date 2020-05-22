import java.io.FileInputStream;
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

        // inputStream with your SOAP content... for the 
        // test I use a fileInputStream pointing to a file
        // which contains the request showed below
        FileInputStream fis = new FileInputStream("/path/yourSOAPReq.xml");

        // create the SOAPMessage
        SOAPMessage soapMessage = mf.createMessage(header,fis);
        // get the body
        SOAPBody soapBody = soapMessage.getSOAPBody();
        // find your node based on tag name
        NodeList nodes = soapBody.getElementsByTagName("someMsg");

        // check if the node exists and get the value
        String someMsgContent = null;
        Node node = nodes.item(0);
        someMsgContent = node != null ? node.getTextContent() : "";

        System.out.println(someMsgContent);
    }

}