Set<String> hashes = new HashSet<>();
RKeys keys = redisson.getKeys();
keys.getKeys().forEach(key -> {
    if (RType.MAP.equals(keys.getType(key))) {
        hashes.add(key);
    }
});