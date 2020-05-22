public static Node deleteNode(Node head, int value) {
    if (head == null) {
        return null;
    }

    while (head.value == value) {
        head = head.next;
        if (head == null) return null;
    }

    Node t1 = head;
    Node t2 = t1.next;

    while (t2 != null) {
        // check for a match
        if (t2.value == value) {
            // splice out node t2
            t1.next = t2.next;
            t2 = t2.next;
        }
        // otherwise advance pointers by one
        else {
            t1 = t2;
            t2 = t2.next;
        }
    }

    return head; 
}