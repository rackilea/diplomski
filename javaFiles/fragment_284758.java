void findNextInPreOrder(TreeNode node, int key) {
    if (node == null) {
        return;
    }
    if (node.value == key) {
       if(node.left != null){
          System.out.print("Next is on left: " + node.left.value);
       } else if (node.right != null){
          System.out.print("Next is on right: " + node.right.value);
       } else {
          System.out.print("There is no next node.");
       }
    }   
    findNextInPreOrder(node.left);   /* then recur on left subtree */
    findNextInPreOrder(node.right);  /* now recur on right subtree */
}