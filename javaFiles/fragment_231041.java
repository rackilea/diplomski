public class LinkedList<E> {
    private Node head = null;

    private class Node {
        E value;
        Node next;

        // Node constructor links the node as a new head
        Node(E value) {
            this.value = value;
            this.next = head;//Getting error here
            head = this;//Getting error here
        }
    }

    public void add(E e) {
        new Node(e);
    }

    public void dump() {
        for (Node n = head; n != null; n = n.next)
            System.out.print(n.value + " ");
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.add("world");
        list.add("Hello");
        list.dump();
    }
}