public class Node<T> {

private T content;
private Node<T> next; // this is a reference to the next node

public Node(T content, Node<T> next) { // next is a Node<T>
    this.content = content;
    this.next = next;
}

...

public Node<T> getNext() { return next; }

public void setNext(Node<T> next) {
    this.next = next;
}