private final List<IntBuffer> array = new ArrayList<IntBuffer>();

public int get(long n) {
    return array.get((int)(n >> 27)).get(n & ((1 << 27) -1));
}

public void put(long n, int v) {
    return array.get((int)(n >> 27)).put(n & ((1 << 27) -1), v);
}