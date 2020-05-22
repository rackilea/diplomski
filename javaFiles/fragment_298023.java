public static int findIndex(int[] my_array, int t) {
    if (my_array == null) {
        return -1;
    }

    int len = my_array.length;
    int i = 0;
    while (i < len) {
        if (my_array[i] == t) {
            return i;
        } else {
            i = i + 1;
        }
    }
    return -1;
}