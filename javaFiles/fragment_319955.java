public static ListNode invert(ListNode head) {
    ListNode temp1;
    ListNode temp2 = null;

    while (head != null) {
        temp1 = head.link;
        head.link = temp2;
        temp2 = head;
        head = temp1;
    }

    return temp2;
}