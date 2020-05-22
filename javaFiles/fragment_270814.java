Node n = new Node(tail, null, link); // The new tail
if (head == null) {
    head = n;
    tail = n;
}else{
    tail.next = n;
    tail = n;
}