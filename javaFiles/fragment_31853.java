public void insertLast(Object newValue) {
    DSAListNode newNd;
    newNd = new DSAListNode(newValue);
    if (head == null) {
        head = newNd;
        tail = newNd; // this should be added
    } else {
        tail.next = newNd;
        tail = newNd;
    }
}