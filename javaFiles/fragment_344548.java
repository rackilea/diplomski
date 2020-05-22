public class Node<T> {
private T data;
private Node<T> parent;
private Map<T, Node<T>> children;

public Node(T data, Node<T> parent) {
    this.data = data;
    this.parent = parent;
    parent.addChild( this);
}

public Node(T data) {
    this.data = data;
}

public boolean hasChildren() {
    if (this.children != null) {
        return this.children.size() > 0;
    }
    return false;
}

public void setParent(Node<T> parent) {
    this.parent = parent;
}

public void addChild(T data) {
    Node<T> child = new Node<T>(data);
    this.children.put(child.data, child);
}

public void addChild(Node<T> child) {
    this.children.put(child.data, child);
}