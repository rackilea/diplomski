public void minHeapify(int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    int smallest = i;

    if (left < heap.size() - 1 && lessThan(left, smallest))
        smallest = left;

    if (right < heap.size() - 1 && lessThan(right, smallest))
        smallest = right;