public class BinaryTree {
    public Node root;

    public void insert(Student s) {
        root = insert(s,root);
    }

    private Node insert(Student s, Node t) {
        if (root == null) return new Node(s);

        if (...) // compare names