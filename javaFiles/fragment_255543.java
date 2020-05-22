public void addLast(Item item)           // insert the item at the end
{
    Node newLast = new Node();
    newLast.item = (String)item;
    if (isEmpty()) {
        first = newLast;
    } else {
        last.next = newLast;
        newLast.previous = last;
    }
    last = newLast;
    N++;
}