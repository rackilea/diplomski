ConcurrentMap<K,V> map = new ConcurrentHashMap<> ();
V value = map.get(key);
if (value == null) {
    value = new V();
    V previousValue = map.putIfAbsent(key, value);
    if (previousValue != null) { //Here you need to be sure what that means
        value = previousValue;
    }
}
useValue(value);