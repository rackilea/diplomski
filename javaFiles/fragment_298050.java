while (true) 
{
        MutableTreeNode child = new DefaultMutableTreeNode("test");
        model.insertNodeInto(child, root, root.getChildCount());
        final int rowToExpand = tree.getRowCount() - 1; // ? does this work ?
        SwingUtilities.invokeLater(new Runnable()
        {
           public void run()
           {
               tree.expandRow(rowToExpand);
           }
        });

}