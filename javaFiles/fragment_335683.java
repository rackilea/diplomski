public class MyQueue<E> implements Queue<E> {
    private Object[] elements;
    private int startOfQueueIndex;
    private int numberOfElements;

    public MyQueue(int initialCapacity) {
        elements = new Object[initialCapacity);
        startOfQueueIndex = 0;
        numberOfElements = 0;
    }

    public boolean add(E e) {
        if (numberOfElements == elements.length)
            increaseElementArraySize();

        elements[(startOfQueueIndex + numberOfElements++) % elements.length] = e;
    }

    public E remove() {
        if (numberOfElements == 0)
            throw new NoSuchElementException();

        E element = (E)elements[startOfQueueIndex];

        startOfQueueIndex = (startOfQueueIndex + 1) % elements.length;

        return element;
    }

    // The rest of the methods go here ...
}