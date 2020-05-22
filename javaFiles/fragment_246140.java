current = front; // front of this list
    ListNode prev = null;
    ListNode frontOther = null;
    while (current != null) {
        temp = new ListNode(current.data);
        if (prev != null) {
            prev.next = temp; // link the previous node to the new node
        } else {
            frontOther = temp; // keep a reference to the first node of the new nodes
        }
        prev = temp;
        current = current.next;
    }