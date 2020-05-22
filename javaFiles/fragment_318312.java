TreeWillExpandListener treeWillExpandListener = new TreeWillExpandListener() {
      public void treeWillCollapse(TreeExpansionEvent treeExpansionEvent)
          throws ExpandVetoException {

        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();

        //Print the name of the node if toString() was implemented
        String data = node.getUserObject().toString();
        System.out.println("WillCollapse: " + data);

      }

      public void treeWillExpand(TreeExpansionEvent treeExpansionEvent) throws ExpandVetoException {

        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();

        //print the name of the node if toString was implemented  
        String data = node.getUserObject().toString();
        System.out.println("WillExpand: " + data);

      }
    };

tree.addTreeWillExpandListener(treeWillExpandListener);