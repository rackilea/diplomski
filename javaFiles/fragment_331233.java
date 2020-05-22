void insert(Node n, int value) {
     if(n == null) {
           n = new Node(value);
     } else if(value < n.value) {
           if(n.left == null) {
               n.left = new Node(value);
               return;
           }
           insert(n.left, value);
     } else if(value > n.value) {
           if(n.right == null) {
                n.right = new Node(value);
                return;
           }
           insert(n.right, value);
     }
}