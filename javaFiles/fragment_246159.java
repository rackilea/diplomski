public static <E, K, C extends Collection<E>> void 
    mergeMaps2(Map<K, C> receivingMap, 
               Map<K, C> givingMap, 
               Supplier<C> collectionCreator) {
    for (Map.Entry<K, C> entry : givingMap.entrySet()) {
        Collection<E> someCollection = receivingMap.computeIfAbsent(entry.getKey(),
                        k -> collectionCreator.get());
        someCollection.addAll(entry.getValue());
    }
}