public LinkNode popHead() {
    if (first == null) {
        throw new IllegalStateException("can't do that on empty list");
    }
    LinkNode temp = first;
    first = temp.next;
    first.previous = null;
    temp.next = null;
    return temp;
}

public void pushTail(LinkNode node) {
    if (last == null) {
        throw new IllegalStateException("can't do that on empty list");
    }
    last.next = node;
    node.prev = last;
    node.next = null;
    last = node;
}