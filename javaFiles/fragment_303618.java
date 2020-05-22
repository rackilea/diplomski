class LinkedListNode {
    private LinkedListNode previous;
    private LinkedListNode next;
    private Object value;

    LinkedListNode(LinkedListNode p, LinkedListNode n, Object v) {
        this.previous = p;
        this.next = n;
        this.value = v;
    }

    LinkedListNode getPrevious() {
        return this.previous;
    }

    // ...and so on...
}