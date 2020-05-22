public void insertNode(int value) {
    Node temp = new Node(value);
    if (this.head == null) {
        this.head = temp;
    } else {
        Node par = this.head;
        while (par.next != null) {
            par = par.next; 
        }
        par.next = temp;
    }
}