public static void heapSort(Comparable[] a, int size)
{
    MaxHeapPriorityQueue mhpq = new MaxHeapPriorityQueue();
    mhpq.elementData = a;
    mhpq.size = size;

    for (int i = (size/2)-1; i >= 0; i--)
    {
        mhpq.bubbleDown(i);
    }
    for(int i = size-1; i >= 0; i--)
    {
        a[i] = mhpq.sortRemove();
    }
}