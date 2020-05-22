for (String stuff : quoteOne) {
    Integer oldVal = map.get(stuff);
    if (oldVal == null) {
        oldVal = 0;
    }
    map.put(stuff, oldVal+1);
}