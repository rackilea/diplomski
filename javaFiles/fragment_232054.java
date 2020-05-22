public class MyList<E> implements List<E> {
    private Node<E> head;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        // ...
    }

    // ...
}