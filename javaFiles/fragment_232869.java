DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//dbf.setNamespaceAware(true); //If you need namespace support turn this on, it is off by default

Document doc = dbf.newDocumentBuilder().newDocument();

//Add a root element
Element rootElement = doc.createElement("root");
doc.appendChild(rootElement);

Attr att = doc.createAttribute("my-attribute");
att.setValue("value");
rootElement.appendChild(att);