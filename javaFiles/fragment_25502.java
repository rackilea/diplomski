public class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;

        public Node (Item item) {
            this.item = item;
        }
    }

    /* Add node to Queue */
    public void add (Item item) {
        Node<Item> node = new Node(item);
        if (last == null) {
            this.first = node;
            this.last = node;
        } else {
            last.next = node;
            this.last = node;
        }
    }

    /* Static concatenate method */
    public static <Item> Queue concatenate (Queue<Item> A, Queue<Item> B) {
        Queue<Item> copyA = A.copy();
        Queue<Item> copyB = B.copy();
        copyA.last.next = copyB.first;
        return copyA;
    }

    /* Copy method to perform a Deep clone */
    public Queue<Item> copy() {
        Queue<Item> queue = new Queue<>();
        Node<Item> iter = first;
        while (iter != null) {
            queue.add(iter.item);
            iter = iter.next;
        }
        return queue;
    }

    /* Concatenate method that will modify the item invoking it */
    public void concatenateD1(Queue<Item> toAdd) {
        Queue<Item> copyToAdd = toAdd.copy();
        this.last.next = copyToAdd.first;
        this.last = copyToAdd.last;
    }

    /* Concatenate method that will modify both arrays invoking it */
    public void concatenateD2(Queue<Item> toAdd) {
        this.last.next = toAdd.first;
        this.last = toAdd.last;
    }

    /* Print method to Test */
    public void print() {
        Node<Item> iter = first;
        while (iter != null) {
            System.out.println(iter.item);
            iter = iter.next;
        }
    }
}