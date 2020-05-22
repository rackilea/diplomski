// In the heapify:
CustomerQueue swap = arr[i];
arr[i] = arr[largest];
arr[largest] = swap;

// In the sort:
CustomerQueue temp = arr[0];
arr[0] = arr[i];
arr[i] = temp;