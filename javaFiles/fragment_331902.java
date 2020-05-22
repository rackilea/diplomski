public void mergeSort(int[] data) {
    if(data.length <= 1) return;               // Base case: just 1 elt

    int[] a = new int[data.length / 2];        // Split array into two
    int[] b = new int[data.length - a.length]; //   halves, a and b
    for(int i = 0; i < data.length; i++) {
        if(i < a.length) a[i] = data[i];
        else             b[i - a.length] = data[i];
    }

    mergeSort(a);                              // Recursively sort first
    mergeSort(b);                              //   and second half.

    int ai = 0;                                // Merge halves: ai, bi
    int bi = 0;                                //   track position in
    while(ai + bi < data.length) {             //   in each half.
        if(bi >= b.length || (ai < a.length && a[ai] < b[bi])) {
            data[ai + bi] = a[ai]; // (copy element of first array over)
            ai++;
        } else {
            data[ai + bi] = b[bi]; // (copy element of second array over)
            bi++;
        }
    }
}