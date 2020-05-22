public MyList RecReverse() { //my attempt at the recursive method
    if (head.getNext() == null) {
        return this;
    }

    MyList remainder = new MyList();
    remainder.head = head.getNext(); // New list has rest of this list (after head)
    ListNode temp = new ListNode(head.getString()); // save the first thing in list

    remainder = remainder.RecReverse(); //reverse the things in the new 2nd part list

    remainder.end().setNext(temp); // put old head on the end

    return remainder;

}

private ListNode end() {
    ListNode curr = head;
    while (curr.getNext() != null) {
        curr = curr.getNext();
    }
    return curr;
}