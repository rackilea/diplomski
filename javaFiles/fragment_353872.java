public void addToRear(T element) {
    Node end = new Node(element);
    if (head == null){
        head = end;
    } else {
        Node temp = head;
        while(temp.next != null){
             temp = temp.next;
        }
        temp.next = end;
    }

}