private WebserviceInterface ws;

//Assuming this method is only called when not handling a message
public void init()
{
     Service service=Service.create(wsdlUrl,qname);
     ws=service.getPort(WebserviceInterface.class);
}
public boolean handleMessage(SOAPMessageContext ctx)
{
     Boolean outbound = (Boolean)msgContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
     if(!outbound)
     {
          SOAPPart document = ctx.getMessage().getSOAPPart();          
          SOAPHeaderElement wsse = getSecurityHeaderElement(document.getEnvelope());

          //Extra Webservice call
          Element xmlElement=ws.helloWorld();

          Node node = document.importNode(xmlElement.cloneNode(true),true);    
          wsse.appendChild(node);
      }
}