public static Set<String> valueToKeySet(long value) {
    Set<String> keys = new HashSet<String>();
    for (Map.Entry<String, Long> entry : hodnotyUdaju.entrySet()) {
        if ((value & entry.getValue()) != 0) {
            keys.add(entry.getKey());
        }
    }
    return keys;
}