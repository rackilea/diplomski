public void push(K element) {
    if (element == null) {
        throw new NullPointerException("Element was null!");
    }
    QueueNode newNode = new QueueNode(element, first);
    if (first == null) {
        last = newNode;
    }
    first = newNode;
}