public void deleteLarger() {

    Node<T> current = head; 
    Node<T> previous = null;

    while(current != null) {
        if (previous != null && current.getValue().compareTo(previous.getValue()) > 0){
            Node<T> toremove = current;
            current = current.getNext(); 
            remove(toremove.getValue());  // or remove(toremove); ?
        } else {
            previous = current;
            current  = current.getNext(); 
        }
    }
}