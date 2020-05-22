public void delete( Node node) {
         if( node == null ) {
            return;
         }
         if( node.left == null ) {
                swap( node, node.right );
                node.right=null;
         } 
         else if( node.right == null ) {
                swap( node, node.left );
                node.left=null;
         } 
         else {
             Node minNode = node.right;
             while( minNode.left != null ) {
                  minNode = minNode.left;
             }
             swap( node, minNode );
             delete(minNode); // call recursively until you find a node whose left or right is null

        } 
    }