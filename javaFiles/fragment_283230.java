int isBetterHand(int[] array1, int[]array2) {
    i f(array1.length != array2.length) {
        // Use != ----^
        throw new RuntimeException("isBetterHandgot arrays of different length.");
    }
    int arrayLength = array1.length;
    for (int i = 0; i < arrayLength; i++) {
        if (array1[i] > array2[i]) {
            return 1;
        } else if (array1[i] < array2[i]) {
            return -1;
        } 
        // else clause removed here
    }
    return 0;
}