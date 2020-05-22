private static int doArraySum(Object array) {
    if(array == null || !array.getClass().isArray()) return 1;
    int length = Array.getLength(array);
    if(length == 0) return 0;
    return length * doArraySum(Array.get(array, 0));
}

public static int arraySum(Object[] array) {
    return doArraySum(array);
}

public static int arraySum(int[] array) {
    return doArraySum(array);
}

// other primitives