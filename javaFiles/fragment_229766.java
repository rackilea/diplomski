public class LinkedList {

    public interface Linkable<V, L extends Linkable> {
        V getValue();
        L getNext();
        void setNext(L link);
    }

    public static class Node implements Linkable<Integer, Linkable> {
        int value;
        Linkable next;

        Node(int value) {
            this.value = value;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public Linkable getNext() {
            return next;
        }

        @Override
        public void setNext(Linkable link) {
            this.next = link;
        }
    }

    private Linkable head;

    public boolean isEmpty() {
        return this.head == null;
    }

    public Linkable getHead() {
        return head;
    }

    public void add(int v) {
        Node next = new Node(v);
        if (isEmpty()) {
            this.head = next;
        } else {
            Linkable tmp = this.head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(next);
        }
    }
}