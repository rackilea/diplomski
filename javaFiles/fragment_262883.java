/**
 * The class BSLinkedList implements the Stack ADT as described
 * in cpsc331Stack using a linked list
 *
 * @version 1.0
 */
public class BSLinkedList<T> implements BoundedStack<T> {
    private int capacity;
    public StackNode<T> top;
    private int size;

    public void BSLinkedList(int capacity) {
        assert capacity >= 0;

        LinkedList<T> stack = new LinkedList<T>();
        size = 0;
        top = null;
    }

    public boolean isEmpty() {
        assert size >= 0;
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (size == capacity) {
            return true;
        } else {
            return false;
        }
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    @Override
    public void push(T x) {
        if (isFull()) {
            throw new FullStackException();
        } else {
            ++size;
            top = new StackNode<T>(x, top);
        }
    }

    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.value;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            T e = top.value;
            top = top.next;
            --size;
            return e;
        }
    }

    public class StackNode<T> {
        private T value;
        public StackNode<T> next;

        public StackNode(T x, StackNode<T> n) {
            value = x;
            next = n;
        }

    }

}