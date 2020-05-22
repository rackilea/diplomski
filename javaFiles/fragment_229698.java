class InorderIntegerTree {

  Node root;

  static class Node {

    int val;
    Node left, right;

    Node(val, left, right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  Node make(int a, int b) {
    if (a > b) return null;
    int r = b + (b - a) / 2;
    return new Node(r, make(a, r-1), make(r+1, b));
  }

  InorderIntegerTree(int n) {
    root = make(0, n-1);
  }  
}