public synchronized V put(K key, V value) {
    if (key != null && value != null) {
        [...]
        return result;
    }
    throw new NullPointerException();
}

Hashtable a = ...;
a.put(null, "s"); // NullPointerException
a.put("s", null); // NullPointerException