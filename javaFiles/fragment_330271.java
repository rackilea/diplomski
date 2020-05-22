public static String toXml(TreeModel model) throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    DOMImplementation impl = builder.getDOMImplementation();

    // Build an XML document from the tree model
    Document doc = impl.createDocument(null,null,null);
    Element root = createTree(doc, model, model.getRoot());
    doc.appendChild(root);

    // Transform the document into a string
    DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    StringWriter sw = new StringWriter();
    StreamResult sr = new StreamResult(sw);
    transformer.transform(domSource, sr);
    return sw.toString();
}

private static Element createTree(Document doc, TreeModel model, Object node) {
    Element el = doc.createElement(node.toString());
    for(int i=0;i<model.getChildCount(node);i++){
        Object child = model.getChild(node, i);
        el.appendChild(createTree(doc,model,child));
    }
    return el;
}