public void traverse(DefaultMutableTreeNode root)
{
    Field f;

    @SuppressWarnings("rawtypes")
    Enumeration en = root.postorderEnumeration();
    while (en.hasMoreElements())
    {
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) en.nextElement();
        if (currentNode.getParent() != null)
        {
            f = ((Field) ((DefaultMutableTreeNode) currentNode.getParent()).getUserObject());
            f.setSize(f.getSize() + ((Field) ((DefaultMutableTreeNode) currentNode).getUserObject()).getSize());
        }
    }
}