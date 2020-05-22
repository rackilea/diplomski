for (int m = 0 ; m < array2.length - 1; m++) {
    if (array2[m] > array2[m + 1]) {
        temp = array2[m + 1];
        array2[m + 1] = array2[m];
        array2[m] = temp;
        numerical = false;
    }
}