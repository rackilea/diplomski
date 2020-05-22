public void add(E e) {
    Node newNode = new Node<>(e, null);
    if(first == null) {
        first = newNode;
        last = newNode;
    } else {
        last.next = newNode;
        last = last.next;  // Or just last = newNode;
    }
    ++size;
}