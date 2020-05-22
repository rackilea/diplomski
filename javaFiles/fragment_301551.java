private void addNodes(ErdosStruct erdosStruct, DefaultTreeModel tModel) {
    if (erdosStruct.getRoot().getCoAuthCount() == 0) {
        return;
    } else {
        AuthNode node = erdosStruct.getRoot();
        addNodes(node, tModel, (MutableTreeNode) tModel.getRoot());
    }
}

protected void addNodes(AuthNode node, DefaultTreeModel tModel, MutableTreeNode parent) {
    if (node != null) {
        MutableTreeNode newParent = new DefaultMutableTreeNode(node);
        tModel.insertNodeInto(newParent, parent, parent.getChildCount() - 1);
        for (int index = 0; index < node.getCoAuthCount(); index++) {
            AuthNode child = node.getCoAuth(index);
            addNodes(child, tModel, newParent);
        }
    }
}