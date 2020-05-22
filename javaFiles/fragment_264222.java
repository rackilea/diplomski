public void bubbleDown(int index){
    int childIndex = (index * 2) + 1;
    if (childIndex > n)
    {
        // if the first child index is off the end of the heap
        // then the item has no children. (It's a leaf.)
        return;
    }

    // first find the smallest child
    // This test is to prevent checking a right child that doesn't exist.
    if (childIndex < n)
    {
        if (s[childIndex] > s[childIndex+1])
        {
            childIndex = childIndex + 1;
        }
    }

    // childIndex holds the index of the smallest of the node's children.
    // swap if the parent is larger than the smallest child,
    // and then keep bubbling down.
    if (s[index] > s[childIndex])
    {
        swapNode(index, childIndex);
        bubbleDown(childIndex);
    }
}