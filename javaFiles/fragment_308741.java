class Node<T> {
    T value;
    Node next;
    Node(T value) {
        this.value = value;
    }
}

class Stack<T> {
    Node<T> Top;
    Node<T> Min;
    final Comparator<T> valueComparer;
    public Stack(Comparator<T> valueComparer) { this.valueComparer = valueComparer; }
    void push(T value) {
        Node<T> node = new Node<T>(value);
        if(Top == null) {
            Min = node;
        } else {
            Min = valueComparer.compare(Min.value, node.value) < 0 ? Min : node;
        }
        node.next = Top;
        Top = node; 
    }
}