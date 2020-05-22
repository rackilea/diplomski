public Node reverse() {
        if (this == NIL) {
            return NIL;
        }

        return reverse(new Node(this.getItem(), NIL), this.getNext());
    }

    private Node reverse(Node head, Node tail) {
        Node copy = new Node(tail.getItem()); 
        copy.next = head;
        if (tail.getNext() == NIL) {
            return copy;
        }
        return reverse(copy, tail.next);
    }