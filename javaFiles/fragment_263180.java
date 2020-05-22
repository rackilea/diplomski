import java.util.Objects;

public class DoubleLinkLists {

    public static void main(String[] args) {
        DoubleLinkedList dll = new DoubleLinkedList();

        DoubleLinkedList.Node node5 = dll.insertInFront(5);
        DoubleLinkedList.Node node4 = dll.insertInFront(4);
        DoubleLinkedList.Node node2 = dll.insertInFront(2);
        DoubleLinkedList.Node node1 = dll.insertInFront(1);
        DoubleLinkedList.Node node3 = dll.insertBefore(node4, 3);

        System.out.println(dll);
    }


    public static class DoubleLinkedList {
        Node head;

        @Override
        public String toString() {
            Node current = head;
            StringBuilder sb = new StringBuilder();

            while (current != null) {
                sb.append(current.data)
                  .append(" ");
                current = current.next;
            }

            return sb.toString();
        }

        public Node insertBefore(Node givenNode, int data) {
            Node newNode = new Node(data);
            newNode.prev = givenNode.prev;
            givenNode.prev = newNode;
            newNode.next = givenNode;

            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            }

            return newNode;
        }

        public Node insertInFront(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = null;

            if (head != null) {
                head.prev = newNode;
            }

            head = newNode;
            return newNode;
        }

        public static class Node {
            int data;

            Node prev;

            Node next;

            Node(int d) {
                data = d;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return data == node.data;
            }

            @Override
            public int hashCode() {
                return Objects.hash(data);
            }
        }
    }
}