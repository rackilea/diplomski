public Node copy() {
        Node initial= this;
        Node copyNext = this.getNext() == NIL? NIL : this.getNext().copy();
        Node duplicate = new Node(initial.getItem());
        duplicate.next = copyNext;
        return duplicate;
    }