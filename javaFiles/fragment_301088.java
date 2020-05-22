Enumeration<TreeNode> children = ((DefaultMutableTreeNode) node).breadthFirstEnumeration();
 while (children.hasMoreElements()) {
     TreeNode child = children.nextElement();
     Object currentNode = ((DefaultMutableTreeNode) child).getUserObject();
     //cast your currentNode to the check box and set selected or unselected.
 }