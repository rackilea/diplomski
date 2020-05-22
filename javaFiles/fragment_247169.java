int size = 1;
Node<E> tempNode = cursor.getNext();
// NPE occurs here
while (!tempNode.getNext().equals(cursor.getNext())) {
    tempNode = tempNode.getNext();
    size++;
}