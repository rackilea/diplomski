public void add(String item, int pos) {
    if (pos > length) {
         // Probably just throw an out of bounds exception
    }

    Node existingNode = head;
    for (int i = 0; i < pos; i++)
         existingNode = existingNode.getNext();

    Node newNode = new Node(item);
    newNode.setNext(existingNode.getNext());
    existingNode.setNext(newNode);
}