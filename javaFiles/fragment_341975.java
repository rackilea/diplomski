if(head.next == null) {
    // head is last!
    head = null;
    size = 0;
} else {
    previous = head;
    current = head.next;
    // while current is not last, keep going
    while(current.next != null) {
       previous = current;
       current = current.next;
    }
    // current is now on last!
    previous.next = null;
    size--;
}