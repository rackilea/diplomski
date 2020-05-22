ConcurrentHashMap<Long, indexPairs> next = initNext();
BitSet segment = new BitSet();
while(condition) {
    next.replaceAll((p, k) -> {
        for (; k.low < finalK; k.low += p)
            segment.set(k.low);
        k.low -= finalK;
        for (; k.high < finalK; k.high += p)                 
            segment.set(k.high);
        k.high -= finalK;
        return k;
    });
    ... Do something with segment
}