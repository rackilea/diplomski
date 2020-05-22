private static Entry<String, String> lookup(NavigableMap<String, String> map, String key) {
    String keyToFind = key;
    for (;;) {
        Entry<String, String> entry = map.floorEntry(keyToFind);
        if (entry == null)
            return null;
        String foundKey = entry.getKey();
        int prefixLen = 0;
        while (prefixLen < keyToFind.length() && prefixLen < foundKey.length() &&
               keyToFind.charAt(prefixLen) == foundKey.charAt(prefixLen))
            prefixLen++;
        if (prefixLen == 0)
            return null;
        if (prefixLen == foundKey.length())
            return entry;
        keyToFind = key.substring(0, prefixLen);
    }
}