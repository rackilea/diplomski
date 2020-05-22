public static <K, V> Map<K, V> toMap(Object[] array) {
    if (array == null) {
        return null;
    }

    final Map<K, V> map = new HashMap<K, V>((int) (array.length * 1.5));
    for (int i = 0; i < array.length; i++) {
        Object object = array[i];
        if (object instanceof Map.Entry) {
            Map.Entry<K, V> entry = (Map.Entry<K, V>) object;
            map.put(entry.getKey(), entry.getValue());
        } else if (object instanceof Object[]) {
            Object[] entry = (Object[]) object;
            if (entry.length < 2) {
                throw new IllegalArgumentException("Array element " + i 
                      + ", '" + object + "', has a length less than 2");
            }
            map.put((K) entry[0], (V) entry[1]);
        } else {
            throw new IllegalArgumentException("Array element " + i + ", '" 
                   + object + "', is neither of type Map.Entry nor an Array");
        }
    }
    return map;
}