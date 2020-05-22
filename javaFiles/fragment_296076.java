@SuppressWarnings("unchecked")
 public void add(int index, E value)
 {
    if(index > size || index < 0)
    {
        throw new IndexOutOfBoundsException();
    }
    if (first == null)
    {
        Node n = new Node(value, null, null);
        n.next = n;
        n.prev = n;
        first = n;
    }
    else
        {
        Node current = first;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        //current points to node that will follow new node.
        Node n2 = new Node(value, current, current.prev);
        current.prev.next = n2;
        current.prev = n2;
        //update first if necessary.
        if(index == 0)
        {
            first = n2;
        }
    }
    size++;
}