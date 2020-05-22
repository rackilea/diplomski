private AtomicInteger nextIndex;
public int getIndex(String string) {
    Integer n = map.get(string);
    if (n == null) {
        int idx = nextIndex.getAndIncrement();
        n = map.putIfAbsent(string, idx);
        if (n != null) return n;
        reverse_map.put(idx, string);
        return idx;
    }
    return n;
}