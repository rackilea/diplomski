public String recursiveToString(DoubleLinkedListNode<T> current)
{
    if(current == null)
    {
        return "";
    }
    else
    {
        return current.info + " " + recursiveToString(current.next);
    }
}