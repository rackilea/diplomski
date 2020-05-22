public static <K, V, M extends Map<K, V>> M[] split(M table, int chunkSize,
        Supplier<? extends M> mapCreator) {

    int numberOfChunks = (int) Math.ceil(table.size() / (double) chunkSize);

    M[] chunks = (M[]) Array.newInstance(table.getClass(), numberOfChunks);

    Set<K> keys = table.keySet();

    int i = 0, j = -1;
    for (K key : keys) {
        if ((i % chunkSize) == 0) {
            j = j + 1;
            chunks[j] = mapCreator.get();
        }
        chunks[j].put(key, (table.get(key)));
        i = i + 1;
    }

    return chunks;
}