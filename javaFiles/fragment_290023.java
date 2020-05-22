public int add(Object elem) {
    Node node = new Node(elem);

    if (head == null) {
        head = node;
    } else {
        tail.setNext(node);
        node.setPrevious(tail);
    }

    tail = node;
    return value;
}