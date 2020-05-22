for (p = l1.first; p != null; p = p.next, q = q.next){
    lNode.data = p.data + q.data;
    ListNode temp = new ListNode(0, null);
    lNode.next = temp;
    lNode = temp;
}