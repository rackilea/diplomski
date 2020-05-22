private Node<T> head = new Node<T>(null);
private Node<T> last = head;

public void add(T element) {
        Node<T> newNode = new Node<T>(element);
        last.next = newNode;
        last = last.next;
}