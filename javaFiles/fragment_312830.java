public static <E> E mostFrequentElement(Iterable<E> iterable) {
    Map<E, Integer> freqMap = new HashMap<>();
    E mostFreq = null;
    int mostFreqCount = -1;
    for (E e : iterable) {
        Integer count = freqMap.get(e);
        freqMap.put(e, count = (count == null ? 1 : count+1));
        // maintain the most frequent in a single pass.
        if (count > mostFreqCount) {
            mostFreq = e;
            mostFreqCount = count;
        }
    }
    return mostFreq;
}