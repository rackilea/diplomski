if (numElements == 0) {
     head = null;
     tail = null;
}
else {
    head = head.next;
    head.previous = null; // the problematic bit
}