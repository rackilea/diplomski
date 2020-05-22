TransformerFactory transformerFactory = TransformerFactory.newInstance();
Transformer transformer = transformerFactory.newTransformer();
DOMSource source = new DOMSource(doc);
StreamResult result = new StreamResult(new File("/home/riddhish/developerworkspace/SplitString/src/com/updatexmlwithjava/one.xml"));
iterator = traversal.createNodeIterator(a, NodeFilter.SHOW_ELEMENT, null, true);          
doc = docBuilder.newDocument();
Element rootElement = doc.createElement("ScrollView");
doc.appendChild(rootElement);
for (Node n = iterator.nextNode(); n != null; n = iterator.nextNode()) {               
        rootElement.appendChild(doc.importNode(n, true));
}
transformer.transform(source, result);