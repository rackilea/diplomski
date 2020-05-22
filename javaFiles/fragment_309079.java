Node node = // the node you want to serialize
xmlOutput = new StreamResult(new StringWriter());
transformer = TransformerFactory.newInstance().newTransformer();
transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
transformer.transform(new DOMSource(node), xmlOutput);
String nodeAsAString = xmlOutput.getWriter().toString();