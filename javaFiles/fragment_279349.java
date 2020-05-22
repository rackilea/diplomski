private Node next = null;
private int value;

public Node(Node node, int value) {
    this.next = node;
    this.value = value;
}

public Node getNext() {
    return next;
}

public void setNext(Node node) {
    this.next = node;
}

public int getValue() {
    return value;
}

public void setValue(int value) {
    this.value = value;
}