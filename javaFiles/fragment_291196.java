private static Node reverseList(Node head) {
    Node res = null;    
    while (head != null) {
        Node node = new Node(head.value);
        node.next = res;
        res       = node;
        head      = head.next;
    }    
    return res;
}