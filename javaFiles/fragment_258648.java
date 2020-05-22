class DoublyLinkedList<E>
{
    private Node first;
    private int size;

    public void add(E value)
    {
        if(first == null)
        {
            first = new Node(value, null, null);
            first.next = first;
            first.prev = first;
        }
        else
        {
            first.prev.next = new Node(value, first, first.prev);
            first.prev = first.prev.next;
        }
        size++;
    }

    private class Node<E>
    {
        private E data;
        private Node next;
        private Node prev;

        public Node(E data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
}