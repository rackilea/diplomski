public class DLL<E extends Comparable<E>> {
    class Node {
        Node next;
        Node prev;
        E data;

        Node() {
            next = null;
            prev = null;
            data = null;
        }

        Node(E dt) {
            next = null;
            prev = null;
            data = dt;
        }
    }

    Node head;

    void insertToHead(E dt) {
        if (head == null) {    
            head = new Node(dt);
        }    
        else {
            head.prev = new Node(dt);
            head.prev.next = head;
            head = head.prev;
        }
    }

    public static void main(String args[]) {    
        DLL<Integer> dll = new DLL<Integer>();

        dll.insertToHead(1);
        dll.insertToHead(2);
        dll.insertToHead(3);
    }
}