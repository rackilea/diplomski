public void insert(Date212 d) {
    ListNode n = new ListNode(d);
    ListNode p = first;

    // Find the insertion point
    while ((p.next != null) && (p.next.data.compareTo(d) < 0)) {
        p = p.next;
    }

    // Insert the node
    n.next = p.next;
    p.next = n;

    if (n.next == null) {
        last = n;
    }

    // Update the list length
    length++;
}