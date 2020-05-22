class Node<T> {
    private Node<T> next;
    private T value;

    Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }
}