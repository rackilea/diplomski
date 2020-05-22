public LinkedList<Elem<E>> remove(int from, int to) 
{
    Elem<E> left = head;      
    for (int i=0; i < from; i++) 
    {
        left = left.next;

    }
    Elem<E> right = left;
    for(int i = 0; i< to - from; i++){
      right = right.next;
    }
    // removing the elements from the list;
    left.next = right;
    right.previous = left;
    size -= ((to - from)+1);

    //left to right are still linked, so just shove them into
    //a new linkedlist and return.
    LinkedList<E> ret = new LinkedList<E>();
    ret.head = left;
    ret.tail = right;
    return ret;
}