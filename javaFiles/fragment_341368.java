private static int[] deleteArrayDuplicates(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] == NEUTRAL) continue; //if zero is a valid input value then don't waste time with it
        int idx = i + 1;  //no need for third cycle, just use memorization for current shifting index.
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                array[j] = NEUTRAL;
            } else {
                array[idx++] = array[j];
            }
        }
    }
    return array;
}