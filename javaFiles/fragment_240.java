int temp;
for (int i = 0; i < array.length-1; i++) {
    // If i is negative, this should be skipped.
    if (i != -1 && array[i] < array[i+1]) {
        temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
        i -= 2;
    }
}