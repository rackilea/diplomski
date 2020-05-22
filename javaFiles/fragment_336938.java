private static Element createTree(Document doc, TreeModel model, Object node) {
        Element el = doc.createElement(node.toString());
        for(int i=0;i<model.getChildCount(node);i++){
                DefaultMutableTreeNode child = (DefaultMutableTreeNode)model.getChild(node, i);
        if (child.isLeaf()) {
                    el.setTextContent(child.toString());
         } else {
                    el.appendChild(createTree(doc,model,child));
        }
    }
    return el;
}