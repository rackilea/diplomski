for(int i=0;i<children.getLength();i++) {
    if(children.item(i).getNodeType() == Node.ELEMENT_NODE) {
        Element elem = (Element)children.item(i);
        // If your document is namespace aware use localName
        String localName = elem.getLocalName();
        // Tag name returns the localName and the namespace prefix
        String tagName= elem.getTagName();
        // do stuff with the children
    }
}