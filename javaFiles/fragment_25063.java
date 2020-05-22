QuikSort qs = new QuickSort(myList);
qs.start();

// When you need to wait for the sort to be done:
// Don't try to use the list before hand because it's
// state will be undefined.
qs.join();