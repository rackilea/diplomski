int getMax(Node root) { //check if root is null
   if(root.right == null) {
       return root.data 
   } else {
       return getMax(root.right)
   }
}