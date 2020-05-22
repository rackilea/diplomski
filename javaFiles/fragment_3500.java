/**
 * Convert document to string for display
 * @param doc org.w3c.dom.Document
 * @return String
 */
private String documentToString(org.w3c.dom.Document doc) throws TransformerException {

    // Create dom source for the document
    DOMSource domSource=new DOMSource(doc);

    // Create a string writer
    StringWriter stringWriter=new StringWriter();

    // Create the result stream for the transform
    StreamResult result = new StreamResult(stringWriter);

    // Create a Transformer to serialize the document
    TransformerFactory tFactory =TransformerFactory.newInstance();
    Transformer transformer = tFactory.newTransformer();
    transformer.setOutputProperty("indent","yes");

    // Transform the document to the result stream
    transformer.transform(domSource, result);        
    return stringWriter.toString();
}