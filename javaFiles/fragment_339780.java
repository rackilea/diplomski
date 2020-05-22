public void duplicate(ListNode front) {
    //ListNode head = front;
    ListNode temp = front;
    int size = 0;
    while (temp != null && temp.getNext() != null) {
        temp = temp.getNext();
        size++;
    }
    ListNode head = front;

    while (head != null && size-- >= 0) {
        temp.setNext(new ListNode(head.getValue(), null));
        temp = temp.getNext();
        head = head.getNext();
    }
}