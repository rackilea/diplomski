import java.io.ByteArrayOutputStream;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author Daniel Chang Yan
 */
public class CustomHandler implements SOAPHandler<SOAPMessageContext> {

public boolean handleMessage(SOAPMessageContext context) {
    Boolean isOutbound
            = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if (isOutbound != null && isOutbound) {
        SOAPMessage soapMsg = context.getMessage();
        try {
            //Properties always rewritten by jaxws, no matter what is set here
            //soapMsg.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "UTF-16");
            //soapMsg.setProperty(SOAPMessage.WRITE_XML_DECLARATION, "false");

            // get SOAP-Part
            SOAPPart sp = soapMsg.getSOAPPart();

            //edit Envelope
            SOAPEnvelope env = sp.getEnvelope();
            env.addNamespaceDeclaration("xsd", "http://www.w3.org/2001/XMLSchema");
            env.addNamespaceDeclaration("xsi", "http://www.w3.org/2001/XMLSchema-instance");

        } catch (SOAPException e) {
            throw new RuntimeException(e);
        }

        // print SOAP-Message
        System.out.println("Direction=outbound (handleMessage)...");
        dumpSOAPMessage(soapMsg);

    } else {
        // INBOUND
        System.out.println("Direction=inbound (handleMessage)...");
        SOAPMessage msg = ((SOAPMessageContext) context).getMessage();
        dumpSOAPMessage(msg);

    }

    return true;
}

public Set<QName> getHeaders() {
    return null;
}

public boolean handleFault(SOAPMessageContext context) {
    System.out.println("ServerSOAPHandler.handleFault");
    boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
    if (outbound) {
        System.out.println("Direction=outbound (handleFault)...");
    } else {
        System.out.println("Direction=inbound (handleFault)...");
    }
    if (!outbound) {
        try {
            SOAPMessage msg = ((SOAPMessageContext) context).getMessage();
            dumpSOAPMessage(msg);
            if (context.getMessage().getSOAPBody().getFault() != null) {
                String detailName = null;
                try {
                    detailName = context.getMessage().getSOAPBody().getFault().getDetail().getFirstChild().getLocalName();
                    System.out.println("detailName=" + detailName);
                } catch (Exception e) {
                }
            }
        } catch (SOAPException e) {
            e.printStackTrace();
        }
    }
    return true;
}

public void close(MessageContext mc) {
}

/**
 * Dump SOAP Message to console
 *
 * @param msg
 */
private void dumpSOAPMessage(SOAPMessage msg) {
    if (msg == null) {
        System.out.println("SOAP Message is null");
        return;
    }
    //System.out.println("");
    System.out.println("--------------------");
    System.out.println("DUMP OF SOAP MESSAGE");
    System.out.println("--------------------");
    try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        msg.writeTo(baos);
        System.out.println(baos.toString(getMessageEncoding(msg)));

        // show included values
        String values = msg.getSOAPBody().getTextContent();
        System.out.println("Included values:" + values);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/**
 * Returns the message encoding (e.g. utf-8)
 *
 * @param msg
 * @return
 * @throws javax.xml.soap.SOAPException
 */
private String getMessageEncoding(SOAPMessage msg) throws SOAPException {
    String encoding = "utf-8";
    if (msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING) != null) {
        encoding = msg.getProperty(SOAPMessage.CHARACTER_SET_ENCODING).toString();
    }
    return encoding;
}
}