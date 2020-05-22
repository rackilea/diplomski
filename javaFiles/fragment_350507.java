public void insertHead(int n) {
    if (isEmpty()) {
        head = tail = new DLLNode(n);
    } else {
        head = new DLLNode(n, head, null);
        head.next.prev = head;
    }
}