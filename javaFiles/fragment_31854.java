public Object removeFirst() {
    Object nodeValue;
    if (head == null) {
        throw new IllegalArgumentException("head is empty");
    } else {
        nodeValue = head.getValue();
    }

    head = head.getNext();
    // the following block should be added
    if (head == null) {
        tail = null;
    }
    return nodeValue;
}