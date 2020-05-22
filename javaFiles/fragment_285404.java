public class LinkedList<T extends Comparable<? super T>> {
private Node top;
private int no_of_items;

private class Node {
    T data;
    Node next;
}

public LinkedList() {
    top = null;
}

public boolean isEmpty() {
    return (top == null);
}

public void insert(T item) {
    Node node = new Node();
    node.data = item;
    node.next = top;
    if(isEmpty()) {
        top = node;
    } else {
        Node n = top; 
        while(n.next != null) {
            n = n.next;
        }
        n.next = node;
    }
    no_of_items++;

}
    }