public static class CircularList<E> implements Iterable<E> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {

        private E data;
        private Node next = null;

        private Node(E data) {
            this.data = data;
        }
    }

    public void addValue(E item) {
        Node n = new Node(item);
        if (emptyList()) {
            //only one value in the list
            first = n;
            last = n;
        } else { //if the list has at least one value already
            //store the old first value
            Node temp = first;
            //the new first is the input value
            first = n;
            //next value after first is the old first value
            first.next = temp;
            //if after this there will be only two values in the list once it is done
            if (size == 1) {
                last = temp;
            }
            //if the list is greater than one than the last value does not change, since any other values will be put before last in this case, and not replace it
            //creating the circular part of the list
            last.next = first;
        }
        size++;
    }

    public boolean emptyList() {
        boolean result = false;
        if (first == null && last == null) { //if there is no values at all
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularIterator(); //each time this method is called it will be creating a new instance of my Iterator
    }

    private class CircularIterator implements Iterator<E> {

        // Start at first.
        Node next = first;

        public CircularIterator() {
        }

        @Override
        public boolean hasNext() {
            // Stop when back to first.
            return next != null;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E n = next.data;
                next = next.next;
                if (next == first) {
                    // We're done.
                    next = null;
                }
                return n;
            } else {
                throw new NoSuchElementException("next called after end of iteration.");
            }
        }
    }
}

public void test() {
    CircularList<String> c = new CircularList<>();
    c.addValue("A");
    c.addValue("B");
    c.addValue("C");
    c.addValue("D");
    for (String s : c) {
        System.out.println(s);
    }
}