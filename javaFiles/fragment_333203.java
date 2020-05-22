public class Node {
    Node left, right; // created as required
    String element;
    Node parent;

    public Node(Node parent, String element) {
        this.parent = parent;  
        this.element = element; // if you don't have an element you don't need a Node.
    }
}