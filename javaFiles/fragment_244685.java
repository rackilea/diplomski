class CustomTree {
    Node root;

    public CustomTree(Node root) {
        this.root = root;
    }
}

class Node {
    Class value;
    List<Node> children;

    public Node(Class value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void addChild(Class clazz) {...}
}