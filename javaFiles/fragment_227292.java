TransformerFactory transFactory = TransformerFactory.newInstance();
Transformer transformer = transFactory.newTransformer();
StringWriter buffer = new StringWriter();
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
transformer.transform(new DOMSource(document),
      new StreamResult(buffer));
String str = buffer.toString();