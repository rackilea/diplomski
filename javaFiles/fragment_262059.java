private class Node
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