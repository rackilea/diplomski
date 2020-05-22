public static ListNode reverseSecondHalfList2(ListNode head) {
    if (head == null || head.next == null)      return head;

    ListNode preMid = getPreMidListNode(head);
    reverse(preMid);
    return head;
}

private static void reverse(ListNode preMid) {
    ListNode pre = preMid.next;
    ListNode cur = pre.next;
    while (cur != null) {
        pre.next = cur.next;
        cur.next = preMid.next;
        preMid.next = cur;
        cur = pre.next;
    }
}

private static ListNode getPreMidListNode(ListNode head) {
    // Add one more node before head, it will help us find the node which before mid note.
    ListNode newHead  = new ListNode(0);
    newHead.next= head;
    ListNode fast = newHead;
    ListNode slow = newHead;
    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}