public static int countNonNullElements(Object[] array) {
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] != null) {
            count++;
        }
    }
    return count;
}