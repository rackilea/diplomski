public class MaxHeapPriorityQueue<E extends Comparable<E>> {
    private E[] elementData;
    private int size;

    @SuppressWarnings("unchecked")
    public MaxHeapPriorityQueue() {
        elementData = (E[]) new Comparable[10];
        size = 0;
    }

    public void add(E data) {
        if (size == 10) throw new IllegalStateException("Queue full");

        elementData[size] = data;
        size++;
    }

    public Iterator<E> iterator() {
        return new MHPQIterator();
    }

    public class MHPQIterator implements java.util.Iterator<E>
    {
        private int index=-1;

        public boolean hasNext()
        {
            return (index+1)<size;
        }

        public E next()
        {
            index++;
            return elementData[index];
        }
    }

    public static void main (String[] args) {
        MaxHeapPriorityQueue<Integer> queue = new MaxHeapPriorityQueue<>();
        Iterator<Integer> iterator = queue.iterator();

        System.out.println("Empty queue:");
        while (iterator.hasNext())
            System.out.println(iterator.next());

        queue.add(1);

        System.out.println("Queue with 1 element (1):");
        iterator = queue.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        queue.add(2);
        queue.add(3);
        queue.add(4);

        System.out.println("Queue with 4 elementa (1,2,3,4):");
        iterator = queue.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}