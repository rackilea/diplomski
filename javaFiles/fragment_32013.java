public void add(String title){
    DvdNode addThis = new DvdNode(title);
    DvdNode iter = head;
    DvdNode prev = null;

    while (iter && addThis.name.compareTo(iter.name) < 0){
        prev = iter;
        iter = iter.getNext();
    }
    addThis.setNext(iter);
    addThis.setPrev(prev);
    if (prev)
        prev.setNext(addThis);
    if (iter)
        iter.setPrev(addThis);
    if (head == null)
        head = addThis;
}