if (head.getVal() == v) {
    head = head.getNext();
    if (head != null) {
        head.setPrev(null);
    } else {
        // If head.getNext() returns null, then tail must have been equal to head.
        tail = null;
    }
}