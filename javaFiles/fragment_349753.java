SOAPHeaderElement actionElement = header.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "Action"));
actionElement.setMustUnderstand(true);
String action = (String) messageContext.get("javax.xml.ws.soap.http.soapaction.uri");
actionElement.addTextNode(action);

SOAPHeaderElement replyToElement = header.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "ReplyTo"));
SOAPElement addressElement = replyToElement.addChildElement(new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing","Address"));
addressElement.addTextNode("http://www.w3.org/2005/08/addressing/anonymous");

SOAPHeaderElement toElement = header.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "To"));
toElement.setMustUnderstand(true);
String endpoint = (String) messageContext.get("javax.xml.ws.service.endpoint.address");
toElement.addTextNode(endpoint);

SOAPHeaderElement messageIdElement = header.addHeaderElement(new QName("http://www.w3.org/2005/08/addressing", "MessageID"));
messageIdElement.addTextNode("uuid:" +UUID.randomUUID().toString());