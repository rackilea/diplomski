public static void main(String[] args) throws Exception {
    Iterator<byte[]> iterator = new PermutationIterator(4);
    while (iterator.hasNext()) {
        System.out.println(Arrays.toString(iterator.next()));
    }
}

private static final class PermutationIterator implements Iterator<byte[]> {
    private final int max;
    private final int n;
    private int current;

    public PermutationIterator(int n) {
        this.n = n;
        this.max = (int) Math.pow(2, n);
    }

    @Override
    public boolean hasNext() {
        return current < max;
    }

    @Override
    public byte[] next() {
        byte[] bytes = new byte[n];
        for (int i = 0; i < n; i++) {
            bytes[i] = (byte) ((current >>> i) & 1);
        }
        current++;
        return bytes;
    }