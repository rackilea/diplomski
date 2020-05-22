public static ListNode reverseSecondHalfList(ListNode head) {
    if (head == null || head.next == null)      return head;

    // Add one more node before head, it will help us find the node which before mid note.
    ListNode newHead  = new ListNode(0);
    newHead.next= head;
    ListNode fast = newHead;
    ListNode slow = newHead;
    while (fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode pre = slow.next;
    ListNode cur = pre.next;
    while (cur != null) {
        pre.next = cur.next;
        cur.next = slow.next;
        slow.next = cur;
        cur = pre.next;
    }
    return head;
}