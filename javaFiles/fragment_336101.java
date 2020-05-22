private void calculateSum(int[] array, int index) {
    if (index > 0) {
        calculateSum(array, index-1);
        array[index] += array[index-1];
    }
}