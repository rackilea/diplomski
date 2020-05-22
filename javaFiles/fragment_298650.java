DefaultMutableTreeNode currentNode = treeTop.getNextNode();
    do {
       if (currentNode.getLevel()==1) 
            myTree.expandPath(new TreePath(currentNode.getPath()));
       currentNode = currentNode.getNextNode();
       }
    while (currentNode != null);