public static String[] splitStringToChunks(String inputString, int... chunkSizes) {
    List<String> list = new ArrayList<>();
    int chunkStart = 0, chunkEnd = 0;
    for (int length : chunkSizes) {
        chunkStart = chunkEnd;
        chunkEnd = chunkStart + length;
        String dataChunk = inputString.substring(chunkStart, chunkEnd);
        list.add(dataChunk.trim());
    }
    return list.toArray(new String[0]);
}