public void addDNode(DNode v) {
    if (header == null) {  // means list is empty, so add first element
        if (tail != null)  
            throw new AssertionError(); // if head points to null then tail should too

        header = v;
        tail = header;  // first element so (head == tail)
    } else {
        tail.setNext(v);
        v.setPrev(tail);
        v.setNext(null);
        tail = v;
    }
}