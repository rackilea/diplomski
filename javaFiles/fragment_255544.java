public void addFirst(Item item) {
    Node newFirst = new Node();
    newFirst.item = (String)item;
    if (isEmpty()) {
        last = newFirst;
    } else {
        first.previous = newFirst;
    }
    newFirst.next = first;
    first = newFirst;
    N++;
}