public class BinList {
    private Node root = ...;

    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }
}

public class Node {
    private Node left, right;
    private Object data;

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.printl(data);
        if (right != null) {
            right.printInOrder();
        }
    }
}