...
    int biggest = index;
    if(leftChild < currentSize && heapArray[leftChild].getKey() > heapArray[index].getKey())
        biggest = leftChild;  //LeftChild is bigger
    if(rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[biggest].getKey())
        biggest = rightChild; //RightChild is bigger than both leftChild and the index node

    if(biggest != index) //If a swap is needed
    {
        //Swap
        Node swapper = heapArray[biggest];
        heapArray[biggest] = heapArray[index];
        heapArray[index] = swapper;

        restoreHeap(biggest);
    }
}