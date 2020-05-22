void swap(Node first, Node second) {
    Node firstPrev = first.getPrev();
    Node firstNext = first.getNext();
    Node secondPrev = second.getPrev();
    Node secondNext = second.getNext();

    if (firstPrev) {
        firstPrev.setNext(second);
    }
    if (firstNext) {
        firstNext.setPrev(second);
    }
    if (secondPrev) {
        secondPrev.setNext(first);
    }
    if (secondNext) {
        secondNext.setPrev(first);
    }

    second.setPrev(firstPrev);
    second.setNext(firstNext);
    first.setPrev(secondPrev);
    first.setNext(secondNext);
}