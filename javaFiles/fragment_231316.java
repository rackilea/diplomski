public void insert(Link newNode)
{
    if(head == null)
    {
        head = newNode;
        tail = newNode;
    }
    else
    {
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

}