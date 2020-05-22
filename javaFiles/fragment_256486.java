TransformerFactory transfac = TransformerFactory.newInstance();
Transformer trans = transfac.newTransformer();
trans.setOutputProperty(OutputKeys.METHOD, "xml");
trans.setOutputProperty(OutputKeys.INDENT, "yes");
trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(2));

StringWriter sw = new StringWriter();
StreamResult result = new StreamResult(sw);
DOMSource source = new DOMSource(doc.getDocumentElement());

trans.transform(source, result);
String xmlString = sw.toString();