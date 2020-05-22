public void swap(Node node1, Node node2) {
    if (node1 == null || node2 == null) {
        throw new IllegalArgumentException(
                "The nodes couldn't be null");
    }

    if (node1 == node2) {
        return;
    }

    // make sure node1 is before node2
    if (node1.getPrev() == node2) {
        Node temp = node2;
        node2 = node1;
        node1 = temp;
    }

    Node node1Prev = node1.getPrev();
    Node node1Next = node1.getNext();
    Node node2Prev = node2.getPrev();
    Node node2Next = node2.getNext();

    node1.setNext(node2Next);
    if (node2Next != null) {
        node2Next.setPrev(node1);
    }

    node2.setPrev(node1Prev);
    if (node1Prev != null) {
        node1Prev.setNext(node2);
    }

    if (node1 == node2Prev) {
        node1.setPrev(node2);
        node2.setNext(node1);
    } else {
        node1.setPrev(node2Prev);
        if (node2Prev != null) {
            node2Prev.setNext(node1);
        }

        node2.setNext(node1Next);
        if (node1Next != null) {
            node1Next.setPrev(node2);
        }
    }

    if (node1 == head) {
        head = node2;
    } else if (node2 == head) {
        head = node1;
    }
}