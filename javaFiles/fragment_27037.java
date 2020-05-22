Element root = doc.createElement("root");

Element textNode = doc.createElement("textNode");
Element emptyTextNode = doc.createElement("emptyTextNode");
Element emptyNode = doc.createElement("emptyNode");
Element nullNode = doc.createElement("nullTextNode");

textNode.appendChild(doc.createTextNode("not empty")); // <textNode>not empty</textNode>
emptyTextNode.appendChild(doc.createTextNode(""));     // <emptyTextNode></emptyTextNode>
// emptyNode: no child appended                           <emptyNode /> 
nullNode.appendChild(null);                            // null child appended - causes NPE!!

root.appendChild(textNode);
root.appendChild(emptyTextNode);
root.appendChild(emptyNode);
root.appendChild(nullNode);