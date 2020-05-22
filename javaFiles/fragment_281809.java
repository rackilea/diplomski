// Obtain the root element
Element element = document.getDocumentElement();

// Create an element with the new name
Element element2 = document.createElement("newRootElementName");

// Copy the attributes to the new element
NamedNodeMap attrs = element.getAttributes();
for (int i=0; i<attrs.getLength(); i++) {
  Attr attr2 = (Attr)document.importNode(attrs.item(i), true);
  element2.getAttributes().setNamedItem(attr2);
 }

// Move all the children
while (element.hasChildNodes()) {
  element2.appendChild(element.getFirstChild());
 }

// Replace the old node with the new node
element.getParentNode().replaceChild(element2, element);