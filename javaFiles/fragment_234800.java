Source source = new DOMSource(doc);
StringWriter writer = new StringWriter();
Result result = new StreamResult(writer);

// create a transformer
TransformerFactory transFactory = TransformerFactory.newInstance();
Transformer        transformer  = transFactory.newTransformer();

// set some options on the transformer
transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

// transform the xml document into a string
transformer.transform(source, result);

String xml = writer.getBuffer().toString();