class RandomizedQueue<Item> implements Iterable<Item> {
private static final int ARRAYSIZE = 8; // default array size
private Node[] nodeArray; // contains pointers to the randomized nodes
private int size; // current size of queue

private class Node<Item> {
    private Item k;
    private Node next;
    private Node previos;

}

public RandomizedQueue() // construct an empty randomized queue
{
    super();
    nodeArray = new Node[ARRAYSIZE];
}

@Override
public Iterator<Item> iterator() {
    // TODO Auto-generated method stub
    return null;
}
}