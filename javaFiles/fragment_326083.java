public static boolean isPermutation(int[] array) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] >= array.length || array[i] < 0) {
            return false;
        }
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] == array[j]) {
                return false;
            }
        }
    }

    return true;
}