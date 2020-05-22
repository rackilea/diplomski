public void removeByValue(V value) {
    for(Map<K2, V> childMap : values())
       for(Iterator<V> valueIter = childMap.values(); valueIter.hasNext();)
           if(valueIter.next().equals(value))
               valueIter.remove();
}