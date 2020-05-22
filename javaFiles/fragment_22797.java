public int get(int pos)
{
    DNode current = header;
    for(int i = 1; i <= pos && current != null; i++)
    {
        current = current.next;
    }
    return current.element;
}