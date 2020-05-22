public class NodeTest {

private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * @param args
 */
public static void main(String[] args) {
    Node first = null;
    Node prev = null;
    for (int i = 0; i < 10; i++) {

        Node current = new Node(prev, Integer.toString(i),null);
        if(i==0){
            first = current;
        }
        if(prev != null){
            prev.next = current;
        }
        prev = current;
    }

    System.out.println( findnthToLastRecursion(first,2).item);
}

public static int i = 0;

public static Node findnthToLastRecursion(Node node, int pos) {

    Node result = node;

    if (node != null) {
        result = findnthToLastRecursion(node.next, pos);

        if (i++ == pos) {
            result = node;
        }
    }

    return result;
}
}