MessageFactory messageFactory = MessageFactory.newInstance();
TransformerFactory transformerFactory = TransformerFactory.newInstance();
SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();

Document document = null; // load your document from somewhere

// make your request message
SOAPMessage requestMessage = messageFactory.createMessage();

/// copy your message into the soap message
Transformer transformer = transformerFactory.newTransformer();
DOMSource source = new DOMSource(document);
DOMResult result = new DOMResult(requestMessage.getSOAPBody());
transformer.transform(source, result);

requestMessage.saveChanges();


// make the SOAP call
URL endpoint = new URL("http://example.com/endpoint");
SOAPConnection connection = sfc.createConnection();
SOAPMessage responseMessage = connection.call(requestMessage, endpoint);

// do something with the response message
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
responseMessage.writeTo(outputStream);
System.out.println(new String(outputStream.toByteArray()));