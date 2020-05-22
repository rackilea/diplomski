Node InsertNth(Node head, int data, int position) {
    Node n = new Node();
    n.data = data;

    if (position == 0) {
        n.next = head;
        return n;
    }

    Node last = head;
    for (int count = 0; count < position-1; count++) {
        if (last == null) {
            return null;
        }
        last = last.next;
    }

    n.next = last.next;
    last.next = n;
    return head;
}