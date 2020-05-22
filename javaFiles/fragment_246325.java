public void merge(int[] left, int[] right, int[] array) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
        if (left[i] < right[j])
            array[k++] = left[i++];
        else        
            array[k++] = right[j++];               
    }

    while (i < left.length)
        array[k++] = left[i++];

    while (j < right.length)    
        array[k++] = right[j++];

    return;
}