public void insertAfter(Node newN, Node previousN) {
    if (previousN != null && previousN.getValue() != null) {
        newN.setNext(previousN.next());
        previousN.setNext(newN);
    }
}