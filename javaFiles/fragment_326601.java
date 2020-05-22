Set<String> cache = Collections.newSetFromMap(new LinkedHashMap<String, Boolean>() {
    @Override
    protected boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
        return size() > MAX_ENTRIES;
    }
});