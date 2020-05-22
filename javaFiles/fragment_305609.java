private static void removeEmptyText(Node node){
    Node child = node.getFirstChild();
    while(child!=null){
        Node sibling = child.getNextSibling();
        if(child.getNodeType()==Node.TEXT_NODE){
            if(child.getTextContent().trim().isEmpty())
                node.removeChild(child);
        }else
            removeEmptyText(child);
        child = sibling;
    }
}

private static void write(Document document) throws TransformerException {
    removeEmptyText(document.getDocumentElement());
    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(new File(FILEPATH));
    transformer.transform(source, result);
}