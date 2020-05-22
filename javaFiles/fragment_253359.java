public static Node reverse(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    Node newHead = reverse(head.next);

    // head.next points to the new tail, we push the former head at the end
    head.next.next = head;
    // now head has become the new tail, we cut the end of the list
    head.next = null;

    return newHead;
}