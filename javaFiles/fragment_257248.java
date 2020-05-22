static ListNode reverse(ListNode node) {
    ListNode headNode = null;
    ListNode followerNode = null;
    for (; node != null; node = node.next, followerNode = headNode) {
        (headNode = new ListNode(node.num)).next = followerNode;
    }
    return headNode;
}