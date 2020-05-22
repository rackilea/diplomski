public static Element wrapWordsInContents(Element node, Document document) {
    NodeList children = node.getChildNodes();
    int size = children.getLength();
    Element newElement = document.createElement(node.getTagName());
    for(int i = 0; i < size; i++) {
        if (children.item(i).getNodeType() == Document.ELEMENT_NODE) {
            newElement.appendChild(wrapWordsInContents((Element)(children.item(i)), document));
        } else { // text node
            String text = children.item(i).getTextContent().trim();
            if(text.isEmpty()) {
                continue;
            }
            String[] words = text.split("\\s");
            for(String word : words) {
                Element w = document.createElement("w");
                Node textNode = document.createTextNode(word);
                w.appendChild(textNode);
                newElement.appendChild(w);
            }
        }
    }
    return newElement;
}