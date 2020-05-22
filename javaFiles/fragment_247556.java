final int[] data = new int[] { 5, 4, 2, 1, 3 };
final Integer[] sorted = ArrayUtils.toObject(data);
Arrays.sort(sorted, new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
        // Intentional: Reverse order for this demo
        return o2.compareTo(o1);
    }
});
System.arraycopy(ArrayUtils.toPrimitive(sorted), 0, data, 0, sorted.length);