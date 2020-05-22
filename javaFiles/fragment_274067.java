private void deepCopyTree(Node node, Node nodeCopy) {
     if(node == null) { return; }
     nodeCopy.setFirstName(node.getFirstName());
     nodeCopy.setLastName(node.getLastName());

     if (node.getTestList() == null) { return; }

     for (Node child : node.getChildren()) { 
         Node copiedChild = new Node();
         nodeCopy.addChild(copiedChild);
         buildTree(child, copiedChild);
     }
}