private static boolean hasTwoLengthRun(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i + 1] == array[i]) {
            return true;
        }
    }
    return false;
}