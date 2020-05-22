public class Penultim {

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.append('a');
        list.append('b');
        list.append('a');
        list.append('b');
        list.append('c');
        list.append('d');
        list.append('e');
        list.append('f');
        list.append('b');
        System.out.println(list);
        System.out.println(list.getPenultimateOccurrenceIndex('b', list.getHead(), 0, -1, -1));
    }
}

class Node {
    private char item;
    private Node next;

    public Node(char item, Node next) {
        this.item = item;
        this.next = next;
    }

    public char getItem() {
        return item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        return item + "->";
    }
}

class LinkList {
    private Node head;

    public void append(char item) {
        if (head == null) {
            head = new Node(item, null);
        }
        else if (head.getNext() == null) {
            head.setNext(new Node(item, null));
        }
        else {
            Node node = head.getNext();
            while (node != null) {
                if (node.getNext() == null) {
                    node.setNext(new Node(item, null));
                    break;
                }
                node = node.getNext();
            }
        }
    }

    public Node getHead() {
        return head;
    }

    public int getPenultimateOccurrenceIndex(char item,
                                             Node node,
                                             int ndx,
                                             int penultimate,
                                             int ultimate) {
        if (node == null) {
            return penultimate;
        }
        else {
            if (node.getItem() == item) {
                if (ultimate >= 0) {
                    penultimate = ultimate;
                }
                ultimate = ndx;
            }
            return getPenultimateOccurrenceIndex(item,
                                                 node.getNext(),
                                                 ndx + 1,
                                                 penultimate,
                                                 ultimate);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node);
            node = node.getNext();
        }
        return sb.toString();
    }
}