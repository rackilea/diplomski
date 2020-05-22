// Create DOM
Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
Element root = document.createElement("Root");
document.appendChild(root);
Element foo = document.createElement("Foo");
foo.appendChild(document.createTextNode("Bar"));
root.appendChild(foo);