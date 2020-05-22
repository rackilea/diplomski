@Override
public String unmarshal(Object obj) throws Exception {
   // Be careful, affect a new string writer has to be done within your
   // unmarshaller. If you do this here, it will partially unmarshall. 
   // I can povide more code upon request
   StringWriter stringWriter = new StringWriter();

   TransformerFactory transformerFactory = TransformerFactory.newInstance();
   Transformer transformer = transformerFactory.newTransformer();

   Document document = ((Element) obj).getOwnerDocument();
   transformer .transform(new DOMSource(document), new StreamResult(stringWriter));

   return stringWriter.toString();
}