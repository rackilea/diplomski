public void addToBack(rec) {
    if (first == null)
        first = new(rec)
    else {
        curr = first;
        while (curr.next != null)
           curr = curr.next
        curr.next = new(rec)
    }
}