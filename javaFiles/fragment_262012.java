import java.util.Comparator;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        System.out.println("---------------SortedLinkedList--------------");
        SortedLinkedList<Integer> sortedList = new SortedLinkedList<Integer>(new intComparator());
        sortedList.add(3);
        sortedList.add(5);
        sortedList.add(2);
        for (int i : sortedList) {
            System.out.println(i);
        }
    }
}

class BasicLinkedList<T> implements Iterable<T> {
    public int size;

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    protected Node head;
    protected Node tail;

    public BasicLinkedList() {
        head = tail = null;
    }

    // Add, remove method

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };

    }
}

class SortedLinkedList<T> extends BasicLinkedList<T> {


    private Comparator<T> comp;

    public SortedLinkedList(Comparator<T> comparator) {
        super();
        this.comp = comparator;
    }

    public SortedLinkedList<T> add(T element) {
        Node n = new Node(element);
        Node prev = null, curr = head;
        if (head == null) {
            head = n;
            tail = n;
        }
        // See if the element goes at the very front
        else if (comp.compare(n.data, curr.data) <= 0) {
            n.next = head;
            head = n;
        }
        // See if the element is to be inserted at the very end
        else if (comp.compare(n.data, tail.data) >= 0) {
            tail.next = n;
            tail = n;
        }
        // If element is to be inserted in the middle
        else {
            while (comp.compare(n.data, curr.data) > 0) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = n;
            n.next = curr;
        }

        size++;
        return this;
    }
}

class intComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}