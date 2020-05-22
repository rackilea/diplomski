public class QueueExample<E> {

    private Queue<E> queue = new LinkedList<>();

    public void add(E item) {
        queue.add(item);
    }

    public E peek(int index) {
        E item = null;
        Iterator<E> iterator = queue.iterator();
        while (iterator.hasNext()) {
            E temp = iterator.next();
            if (index-- == 0) {
                item = temp;
                break;
            }
        }
        return item;
    }

    public static void main(String[] args) {
        QueueExample<String> queueExample = new QueueExample<>();
        queueExample.add("One");
        queueExample.add("Two");
        queueExample.add("Three");

        System.out.println(queueExample.peek(0));
        System.out.println(queueExample.peek(2));
        System.out.println(queueExample.peek(1));
        System.out.println(queueExample.peek(4));
    }
}