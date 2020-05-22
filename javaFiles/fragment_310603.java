if(isEmpty()) {
    first = node;
    last = node;
}
else {
    Node tail = last;
    tail.next = node;
    node.next = first;
    last = node;
}