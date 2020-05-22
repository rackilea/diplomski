public static <T> T[] copyOfRange(T[] original, int from, int to) {
    int newLength = to - from;
    if (newLength < 0) throw new IllegalArgumentException(from + " > " + to);
    T[] copy = (T[]) Array.newInstance(original.getClass().getComponentType(), newLength);
    System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
    return copy;
}