public class NodeTree {
    private Node start;
    private int degree;

    public NodeTree() {
        start = new Node();
    }
    static private class Node {
//  ^^^^^^
        private Object root;
        private Node[] subtrees;
        private int size;
        Node() {  }
    }
}