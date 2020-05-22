public void addFirst(Item item)
{
    Node oldfirst;
    if (first != null){
        oldfirst = first;
    }

    first = new Node();
    first.item = item;

    if (oldfirst != null){
        first.next = oldfirst;
        oldfirst.prev = first;
    }
    size++;
}