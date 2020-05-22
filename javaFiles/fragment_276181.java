if (root.left != null) { // tests left root
     if (root.left.left == null && root.left.right == null) { 
         root.left = null; // delete
     } else {
         removeLeaves(root.left);
     }
 }