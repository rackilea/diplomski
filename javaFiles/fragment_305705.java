int[] a = {0, 2, 4, 6, 8};
int[] b = {10, 12, 14, 16, 18};
Arrays.setAll(a, new IntUnaryOperator() {
    public int applyAsInt(int i) {
        return b[i]+1;
    }
});