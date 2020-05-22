DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = factory.newDocumentBuilder();
Document doc = docBuilder.newDocument();
Element root = doc.createElement("root");
root.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
    "xsi:noNamespaceSchemaLocation", "my.xsd");
root.appendChild(doc.createElement("foo"));
doc.appendChild(root);
// see result
DOMImplementationLS dls = (DOMImplementationLS) doc.getImplementation();
System.out.println(dls.createLSSerializer().writeToString(doc));