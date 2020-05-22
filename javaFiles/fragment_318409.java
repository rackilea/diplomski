public Node reverse() {
        Node head = NIL; //initial we have a empty list

        Node current = this; //set cursor to current node

        while (current != NIL) {
            Node copy = new Node(current.getItem()); //create a copy of current node
            copy.next = head; //set head node as next for copy 
            head = copy; //now move head to copy 
            current = current.next; // move cursor for next position
        }

        return head;
    }