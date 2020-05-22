import javax.xml.namespace.QName;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class CDataHandler implements SOAPHandler<SOAPMessageContext> {

  @Override
  public void close(MessageContext context) {
  }

  @Override
  public boolean handleMessage(SOAPMessageContext soapMessage) {
    try {
      SOAPMessage message = soapMessage.getMessage();
      boolean isOutboundMessage = (Boolean) soapMessage
          .get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

      // is a request?
      if (isOutboundMessage) {
        // build a CDATA NODE with the text in the root tag
        Node cddata = (Node) message.getSOAPPart().createCDATASection(
            message.getSOAPBody().getFirstChild().getTextContent());

        // add the CDATA's node at soap message
        message.getSOAPBody().getFirstChild().appendChild(cddata);

        // remove the text tag with the raw text that will be escaped
        message.getSOAPBody().getFirstChild()
            .removeChild(message.getSOAPBody().getFirstChild().getFirstChild());

      }

    } catch (Exception ex) {
      // fail
    }
    return true;
  }

  @Override
  public boolean handleFault(SOAPMessageContext soapMessage) {
    return true;
  }

  @Override
  public Set<QName> getHeaders() {
    return Collections.EMPTY_SET;
  }
}