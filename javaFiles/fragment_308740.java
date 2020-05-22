class Stack<T extends Comparable<T> {
    Node<T> Top;
    Node<T> Min;
    void push(T value) {
        Node<T> node = new Node<T>(value);
        if(Top == null) {
            Min = node;
        } else {
            Min = Min.value.compareTo(node.value) < 0 ? Min : node;
        }
        node.next = Top;
        Top = node; 
    }
}