public class TreeDemo {

   public static void main(String[] args) {
      Tree t = new Tree();
      t.insert(new Node(-1));
      t.insert(new Node(5));
      t.insert(new Node(8));
      t.insert(new Node(-10));
      t.insert(new Node(4));
      t.insert(new Node(-3));
      t.insert(new Node(9));
      t.insert(new Node(12));

      print(t.root);

   }

   public static void print(Node n) {
      if (n.left != null) {
         print(n.left);
      }
      // print inorder
      System.out.println(n.value);
      if (n.right != null) {
         print(n.right);
      }
   }
}

class Node {

   Node  left  = null;
   Node  right = null;
   float value = 0;

   public Node(float value) {

      this.value = value;
      left = null;
      right = null;
   }
}

class Tree {

   Node root;

   public Tree() {
      root = null;
   }
   public void insert(Node node) {
      if (root == null) {
         root = node;
         return;
      }
      insert(root, node);
   }
   // added this method
   private void insert(Node troot, Node node) {

      if (troot.value > node.value) {
         if (troot.left == null) {
            troot.left = node;
         }
         else {
            insert(troot.left, node);
         }
      }
      else {
         if (troot.value <= node.value) {
            if (troot.right == null) {
               troot.right = node;
            }
            else {
               insert(troot.right, node);
            }
         }
      }
   }
}