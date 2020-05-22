class Node<T extends Comparable<T>> {
    T value;
    Node next;
    Node(T value) {
        this.value = value;
    }
}