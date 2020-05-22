import com.sun.xml.ws.developer.WSBindingProvider;

HelloPort port = helloService.getHelloPort();  // or something like that...
WSBindingProvider bp = (WSBindingProvider)port;

bp.setOutboundHeader(
  // simple string value as a header, like <simpleHeader>stringValue</simpleHeader>
  Headers.create(new QName("simpleHeader"),"stringValue"),
  // create a header from JAXB object
  Headers.create(jaxbContext,myJaxbObject)
);