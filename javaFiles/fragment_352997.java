public void insert(E e) {
    Node<E> newNode = new Node<>(e);

    if (root == null) {
        root = newNode;
    } else {
        Node<E> current = root;
        Node<E> parent = null;

        while (true) {
            parent = current;
            if (e.compareTo(current.element) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }
}