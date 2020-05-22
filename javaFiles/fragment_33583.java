public static List<String> cutString(String original, int chunkSize, String encoding) throws UnsupportedEncodingException {
    List<String> strings = new ArrayList<>();
    final int end = original.length();
    int from = 0, to = 0;
    do {
        to = (to + chunkSize > end) ? end : to + chunkSize; // next chunk, watch out for small strings
        String chunk = original.substring(from, to); // get chunk
        while (chunk.getBytes(encoding).length > chunkSize) { // adjust chunk to proper byte size if necessary
            chunk = original.substring(from, --to);
        }
        strings.add(chunk); // add chunk to collection
        from = to; // next chunk
    } while (to < end);
    return strings;
}