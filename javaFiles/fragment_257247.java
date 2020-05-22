static ListNode reverse(ListNode node) {
    ListNode headNode = null;
    ListNode previousNode = null;
    for (; node != null; previousNode = headNode, headNode = node, node = node.next, headNode.next = previousNode)
        ;
    return headNode;
}