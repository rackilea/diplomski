void f(Node node) {
      if(node == null) return;
      f(node.left);
      f(node.right);
      print node.value;
 }