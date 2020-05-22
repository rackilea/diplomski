interface Node {
    public int getValue();
}

class Leaf implements Node {
    private final int value;
    public Leaf(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}

class Composite implements Node {
    private final Node left;
    private final Node right;
    public Composite(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    public int getValue() {
        return left.getValue() + right.getValue();
    }
}