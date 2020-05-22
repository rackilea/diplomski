class NodeImpl implements Node {
    private int value;
    private Node left;
    private Node right;

    public NodeImpl(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        // here you have to put some nice drawing logic.
        return  (left != null ? left.toString() : "") + "<-" + value + "->" + (right != null ? right.toString() : "");
    }
}

class TreeImpl implements Tree {
    private Node root;

    public void setTree(int[] values) {
        Arrays.sort(values);
        this.root = recurseSet(values);
    }

    private Node recurseSet(int[] values) {
        if (values.length > 0) {
            int middleIndex = values.length / 2;
            return new NodeImpl(
                values[middleIndex], recurseSet(cutArray(values, 0, middleIndex - 1)),
                recurseSet(cutArray(values, middleIndex + 1, values.length - 1))
            );
        } else {
            return null;
        }
    }

    private int[] cutArray(int[] array, int begin, int end) {
        int length = end - begin + 1;
        int[] newArray = new int[length];
        System.arraycopy(array, begin, newArray, 0, length);
        return newArray;
    }

    public Node getRoot() {
        return root;
    }
}