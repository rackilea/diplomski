public class Node {

    Object value;
    private Node left;
    private Node right;

    public boolean equals(Object o) {
        if (o instanceof Node) {
            Node node = (Node)o;
            if (value.equals(node.value)) {
                return true;
            }
            return ((left == null && node.left == null) || left.equals( node.left)) && 
                    ((right == null && node.right == null) || right.equals( node.right));
        }
        return false;
    }
}