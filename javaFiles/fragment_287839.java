Node Insert(Node head,int data) {
    if(head == null) {
       Node node = new Node();
       head = node;
       head.data = data;
       head.next = null;
       return head;
    }

    Node current = head;

    while(current.next != null) {
        current = current.next;
    }

    Node node = new Node();
    node.data = data;
    node.next = null;

    current.next = node;

    return head;
}