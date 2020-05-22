if(current != null) {
    while(current.getNext() != null) {
        current = current.getNext();
    }
    current.setNext(new Node<T>(newElt));
}
else {
    current = new Node<T>(newElt, null); // because current is start
}