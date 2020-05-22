static final class Node<E> {
    volatile E item;
    volatile Node<E> next;

    /**
     * Constructs a node holding item.  Uses relaxed write because
     * item can only be seen after piggy-backing publication via CAS.
     */
    Node(E item) {
        ITEM.set(this, item);
    }
    ...
}