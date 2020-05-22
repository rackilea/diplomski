public void insertNode(int value) {
    Node temp = new Node(value);
    if (this.head == null) {
        this.head = temp;
    } else {
        temp.next = this.head;
        this.head = temp;
    }
}