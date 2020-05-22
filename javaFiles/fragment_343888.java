public class Node<T> {
    private T data;   
    private List<Node<T>> children;

    Node<T> find(T data) {
        if (this.data.equals(data)) {
            return this;
        }
        for (Node<T> node : children) {
            Node<T> found = node.find(data);
            if (found != null) {
                return found;
            }
        }
        return null; // Not found.
    }

public class Tree<T> {

    public find(T data) {
        return root == null ? null : root.find(data);
    }

    public boolean insert(T parentData, T data) {
        Node<T> found = find(parentData);
        if (found == null) {
            return false;
        }
        found.getChildren().add(new Node(data));
        return true;
    }