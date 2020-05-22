// parse XML document from file    
DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = db.parse(new FileInputStream(fileName));

// prepare an XPath expression
XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("/Fields/Field[@FieldName='NUMBER']/String");

// retrieve from XML nodes using XPath
NodeList list = (NodeList)xpath.evaluate(doc, XPathConstants.NODESET);

// iterate over resulting nodes and retrieve their values
for(int i = 0; i < list.getLength(); i ++) {
    Node node = list.item(i);
    // udate node content
    node.setTextContent("New text");
}

// output edited XML document
StringWriter writer = new StringWriter(); // Use FileWriter to output to the file
TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
transformer.transform(new DOMSource(doc), new StreamResult(writer));
System.out.println(writer.toString());