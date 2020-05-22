public static int partition(int[] a, int lo, int hi) {
    //choose pivot element
    int pivotIndex = lo; // ERROR 1 fixed
    int pivotVal = a[pivotIndex];

    //put pivot at the end of array
    swap(a, pivotIndex, hi);

    //compare other elements to pivot and swap accordingly
    int storeindex = lo;
    for (int i = lo; i < hi; i++) {
        if (a[i] <= pivotVal) {
            swap(a, i, storeindex);
            storeindex++;
        }
    }

    //set pivot in right place of array
    swap(a, storeindex, hi); // ERROR 2 fixed
    return storeindex; //return 
}