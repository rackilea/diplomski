TransformerFactory transFactory=TransformerFactory.newInstance();
Transformer trans=transFactory.newTransformer();

trans.setOutputProperty(OutputKeys.INDENT, "yes");
trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

trans.transform(new DOMSource(doc),new StreamResult("c:\\file.xml"));