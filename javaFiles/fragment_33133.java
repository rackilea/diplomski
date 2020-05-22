360     final Entry<K,V> getEntry(Object key) {
361         int hash = (key == null) ? 0 : hash(key.hashCode());
362         for (Entry<K,V> e = table[indexFor(hash, table.length)];
363              e != null;
364              e = e.next) {
365             Object k;
366             if (e.hash == hash &&
367                 ((k = e.key) == key || (key != null && key.equals(k))))
368                 return e;
369         }
370         return null;
371     }