private static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
    private E element;

    public int compareTo(Node<E> o) {
       return element.compareTo(o.element);
    }
}