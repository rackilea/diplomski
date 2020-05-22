public class Node {
    Node left, right; // created as required
    String element;

    public Node(String element) {
        this.element = element; // if you don't have an element you don't need a Node.
    }

    public void setLeft(Node left) { this.left = left; }
    public void setRight(Node right) { this.right = right; }
}