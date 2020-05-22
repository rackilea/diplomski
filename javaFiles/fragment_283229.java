for (int i = 0; i < arrayLength; i++) {
    if (array1[i] > array2[i]) {
        return 1;
    } else if (array1[i] < array2[i]) {
        return -1;
    }
    // else claus removed here
}
return 0;