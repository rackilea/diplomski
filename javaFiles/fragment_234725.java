public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode head = new ListNode(-1);  // temporary head node
    ListNode last = head; // the last item of the list; we append here

    while ((l1 != null) && (l2 != null)) { // while both lists arent empty
        if (l1.val <= l2.val) {            // 'or equal' for stable merging
            last.next = l1;                // append the chosen node to result list
            l1 = l1.next;                  // skip (effectively remove) it in input list
        } else {
            last.next = l2;
            l2 = l2.next;
        }
        last = last.next;                  // the appended node becomes last
    }

    // one of the lists is finished - append the rest of the other one
    if (l1 == null) last.next = l2;
    else last.next = l1;

    return head.next;
}