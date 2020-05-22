if (!isEmpty()) {
        Node temp = first;
        Node previousNode = null;
        while (temp.next != null) {
            previousNode = temp;
            temp = temp.next;
        }
        previousNode.next = null;
    }