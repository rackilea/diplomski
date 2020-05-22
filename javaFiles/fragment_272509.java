void Find(int data) {
    // Code to handle head & tail conditions

    Node prevNode = getPreviousNode(data);

    if (prevNode != null) {
        System.out.println("Found");
    }

    ...
}

void Delete(int data) {
    // Code to handle head & tail conditions

    Node prevNode = getPreviousNode(data);

    if (prevNode != null) {
        Node node = prevNode.nextNode;
        prevNode.nextNode = node.nextNode;
        node.nextNode = null;
        System.out.println("Found & Deleted");
    }

    ...
}