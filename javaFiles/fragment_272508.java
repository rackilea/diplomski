private Node getPreviousNode(int data) {
    Node iter = head;

    while (iter.NextNode != null) {
        if (iter.NextNode.data == data) {
            return iter;
        }

        iter.nextNode = iter.nextNode.nextNode;
    }

    return null;
}