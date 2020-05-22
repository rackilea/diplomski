public void insert(E e) {
    Node<E> newNode = new Node<>(e);

    if (root == null) {
        root = newNode;
    } else {
        Node<E> current = root;
        Node<E> parent = null;

        while (true) {
            parent = current;
            if (e.compareTo(current.element) < 0) // missing { ...
                current = current.left; // ... so only this is in the if block

            if (current == null) {
                parent.left = newNode;
                return;
            } else { // oops, this should be else to the e.compareTo(current.element) < 0 condition
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}