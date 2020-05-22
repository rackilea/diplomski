void f(Node node) {
      if(node == null) return;
      print node.value;
      f(node.left);
      f(node.right);
 }