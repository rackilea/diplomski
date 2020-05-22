private static int recursive(int[] ints, int offset) {
    if (ints.length - 1 == offset) {
        return ints[offset];
    } else {
        return Math.max(ints[offset], recursive(ints, offset + 1));
    }
}