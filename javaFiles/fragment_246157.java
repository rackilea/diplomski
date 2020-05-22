public static <E, K, C extends Collection<E>> void 
             mergeMaps2(Map<K, C> receivingMap, Map<K, C> givingMap) {
    for (Map.Entry<K, C> entry : givingMap.entrySet()) {
        Collection<E> someCollection = receivingMap.computeIfAbsent(entry.getKey(), 
                                         k -> (C) new ArrayList<E>());
        someCollection.addAll(entry.getValue());
    }
}