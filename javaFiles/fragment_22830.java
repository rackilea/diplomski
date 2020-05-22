for(String blacklisted : blacklist) {
    wordcounts.remove(blacklisted);
}
for(String mapping : mappings) {
    String oldKey =    // get old key
    String value = wordcounts.get(oldKey);
    wordcounts.remove(oldKey);
    wordcounts.put(mapping, value);
}