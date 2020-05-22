class LinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int length = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value);

        if(length != 0) {
            last.setNext(node);
            last = node;
        }
        else {
            first = node;
            last = node;
        }

        length++;
    }

    public Node<T> getFirst() {
        return first;
    }
}