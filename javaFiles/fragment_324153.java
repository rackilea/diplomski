Map<K,V> map = new HashMap<K,V>(){
public Entry<K,V> get(Object key) { // overloading get method in subclass
     if (key == null)
         return getForNullKey();
     int hash = hash(key.hashCode());
     for (Entry<K,V> e = table[indexFor(hash, table.length)];
          e != null;
          e = e.next) {
         Object k;
         if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
             return e;
     }
     return null;
 }


 private Entry<K,V> getForNullKey() { 
     for (Entry<K,V> e = table[0]; e != null; e = e.next) {
         if (e.key == null)
             return e;
     }
     return null;
 }};
 ...
 Map.Entry<K,V> entry1 = map.get(key);// invoking Entry<K,V> get(Object key)