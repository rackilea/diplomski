final int MAX_ENTRIES = 100;
Map cache = new LinkedHashMap(MAX_ENTRIES+1, .75F, true) {
    // Returns true if this map should remove its eldest entry
    public boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }
};