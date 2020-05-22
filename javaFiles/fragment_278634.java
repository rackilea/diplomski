import javax.swing.JOptionPane;

class Node {
    int info;
    Node fs;
    Node fd;
}

class BinaryTree {

    public static void main(String[] args) {

        Node tree = null;
        tree = insertRecursivePreorder(tree);

    }

    static Node insertRecursivePreorder (Node n) {
      String input = JOptionPane.showInputDialog("Insert node, 0 to end: \n");
      int dato = Integer.parseInt(input);

      if (dato == 0) {
          n=null;
      } else {
          n=new Node();
          n.info=dato;
          n.fs=insertRecursivePreorder(n.fs);
          n.fd=insertRecursivePreorder(n.fd);
      }
      return n;
    }

}