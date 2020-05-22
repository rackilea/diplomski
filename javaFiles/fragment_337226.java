String text = "<child></child>";
Document document = builder.parse(new InputSource(new 
    StringReader(text)));
Element originalElement = document.getDocumentElement();

Element newDocumentElement = 
    document.createElementNS("urn:parent:ns:1.0", 
    originalElement.getNodeName());

// no child elements, otherwise append all children to 
// newDocumentElement

Element importedNode = (Element) parent.importNode(newDocumentElement, 
    true);    
parent.getDocumentElement().appendChild(importedNode);