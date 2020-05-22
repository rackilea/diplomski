@Override
public Stack<E> reverse()
{
    ListStack<E> reversed = new ListStack<E>();

    Node<E> node = first;
    while(node != null)
    {
        reversed.push(node.item);
        node = node.next;
    }

    return reversed;
}