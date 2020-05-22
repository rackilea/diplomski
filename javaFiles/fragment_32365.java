public T next() {
if (nextnode == null)
    throw new NoSuchElementException();
currentnode = nextnode;
previousnode = currentnode.previous;
nextnode = currentnode.next;
return currentnode.element;
}

public void remove() {
if (previousnode != null)
    previousnode.next = nextnode;
if (nextnode != null)
    nextnode.previous = previousnode;
}