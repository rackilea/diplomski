class MyTreeModelListener implements TreeModelListener {

     public void treeNodesInserted(TreeModelEvent e) {
          // first option
          myTree.expandPath(e.getPath());
          // second option
          myTree.setSelectionPath(e.getPath());
     }

     // empty implementation of other listener methods
     ...
} 

// usage
myTree.getModel().addTreeModelListener(new MyTreeModelListener());