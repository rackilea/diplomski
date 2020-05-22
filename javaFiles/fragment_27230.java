public void insertElementBefore(E element, E newElement) {
    MyNode<E> current = head;
    //check here
    MyNode<E> prev = null;
    if (head != null) {
        while (current != null) {
            if (current.data.equals(element)) {
                MyNode<E> n = new MyNode<E>(newElement);
                n.next = current;
                //check here
                if (prev != null) {
                    prev.next = n;
                }
                return;
            }
            //check here
            prev = current;
            current = current.next;
        }
    }
}