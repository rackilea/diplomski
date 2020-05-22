public void foo(){
    while(iterator.hasNext()){
        Entry<K, ? extends Collection<V>> entry = iterator.next();
        Collection<V> value = entry.getValue();
    }
}