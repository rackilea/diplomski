public void stutter() {
    for (ListNode current = front; current != null; ) {
        ListNode duplicate = new ListNode(current.data, current.next);
        current.next = duplicate;
        current = duplicate.next
    }
}