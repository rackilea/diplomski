public void rebuildHeap()
 {
    int half = heapArray.length / 2;
    for(int i = half; i >= 0; i--)
        restoreHeap(i);
 }