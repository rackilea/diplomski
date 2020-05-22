public void moveHeadToTail() {
    if (first == null || last == null) {
        throw new IllegalStateException("can't do that on empty list");
    }
    // Detach the first node
    LinkNode temp = first;
    first = temp.next;
    first.previous = null;
    temp.next = null;

    // Put the tmp node at the end
    last.next = temp;
    temp.prev = last;
    last = temp;
}