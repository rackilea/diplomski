Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(stylesheet));
JDOMSource in = new JDOMSource(doc);
StringWriter writer = new StringWriter();
StreamResult out = new StreamResult(writer);
transformer.transform(in, out);
return writer.toString();