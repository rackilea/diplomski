public static int[] getMaxValues(int count, int... values) {
    int[] v = values.clone();
    Arrays.sort(v);
    return Arrays.copyOfRange(v, v.length - count, v.length);
}

public static void main(String[] args) {
    System.out.println(Arrays.toString(getMaxValues(2, 56, 5, 90, 12, 234, 90)));
}