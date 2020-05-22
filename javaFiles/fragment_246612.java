@Override
public String toString() {
    String listRepresentation = "";
    ListNode<T> currentNode = headNode;

    while (currentNode != null) {
        listRepresentation += currentNode.getInfo() + "\n";
        currentNode = currentNode.getNextNode();
    }

    return listRepresentation;
}