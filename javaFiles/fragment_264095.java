void f(Node node) {
      if(node == null) return;
      f(node.left);
      print node.value;
      f(node.right);
 }