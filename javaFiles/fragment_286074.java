public class NestedHashMap2<K, L, V> extends HashMap<K, HashMap<L,V>> {

    public V put(K k, L l, V v){
        if(! containsKey(k)){
            put(k, new HashMap<L,V>());
        }
        return get(k).put(l, v);
    }

    public V get(K k, L l){
        if(! containsKey(k)) return null;
        return get(k).get(l);
    }

    //Expand as needed
}