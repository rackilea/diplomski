DefaultMutableTreeNode theNode = null;
for (Enumeration e = root.depthFirstEnumeration(); e.hasMoreElements() && theNode == null;) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
    if (whatIWantIs(node.getUserObject)) {
        theNode = node;
    }
}