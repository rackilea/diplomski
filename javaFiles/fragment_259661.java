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