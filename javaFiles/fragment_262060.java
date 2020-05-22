@SuppressWarnings("unchecked")
public E get(int index)
{
    if(index < 0)
    {
        throw new IndexOutOfBoundsException();
    }
    if(index > size)
    {
        throw new IndexOutOfBoundsException();
    }
    Node current = first;
    for (int i = 0; i < index; i++)
    {
        current = current.next;
    }
    return current.data;
}