public void deleteMin(Node p){
    n = n - 1;
    // place root node at the end of the heap,
    // and the last node at the root.
    swapNode(0, n);

    // adjust the heap
    bubbleDown(0);
    return s[n];
}