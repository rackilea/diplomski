private boolean delete (Node n, Value val, boolean cut) {
   boolean status = false;
   // Base case
   if(n == null) return false;
   if(node to be deleted) {
        // Do all sorts of swapping, recursive deletion calls
   }
   else {
       // Move around the tree until I find a node or hit null
       if(is in left subtree){
             status = delete(t.left, val, !cut);
       }else if(is in right subtree){
             status = delete(t.right, val, !cut);
       }         
   }

   // Here is where updating happens
   someUpdateFunction(n);

   return status;
}