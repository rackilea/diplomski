class ValueNode {
    double value;

    public ValueNode(double value) {
        this.value = value;
    }
}

class OpNode {
    Node left;
    Node right;

    public OpNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}