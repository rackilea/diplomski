import java.util.Iterator;

public class RegLinkList<T> implements Iterable<T> {
    private Node<T> head;

    public RegLinkList() {
        head = null;
    }

    public static class Node<T> {
        public Node<T> next = null;
        public T data = null;

        Node(T data) {
            this.data = data;
        }
    }

    public static class ListIterator<T> implements Iterator<T> {
        Node<T> current;
        Node<T> previous;

        public ListIterator(Node<T> head) {
            current = head;
            previous = head;
        }


        @Override
        public boolean hasNext() {
            return false;
        }
        @Override
        public T next() {
            return null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(head);
    }
}