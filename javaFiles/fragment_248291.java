// contains(Object o) will return true if this method returns non-null
// NOTE: Entry<K,V> seems out of place as we are dealing with a Set not a 
//       Map. But in fact the backing structure for HashSet is a type of Map
final Entry<K,V> getEntry(Object key) {
        if (size == 0) { // Set is empty, search element can't be contained
            return null;
        }

        // Calculate the hash of the search key:
        // IF the search key == null --> hash = 0
        // ELSE calculate and assign the hashCode for key inside method 
        //      hash()
        int hash = (key == null) ? 0 : hash(key);

        // Start at hash calculated, after each iteration set e to be 
        // the element that comes after e  (defined by e.next field). Stop 
        // iterating when e is null
        for (Entry<K,V> e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            // IF (the hash calculated from the search key and the hash 
            //     calculated from this Entries key are equal AND
            //     this Entries key equals the search key) OR
            //    (search key != null AND the search key equals this Entries 
            //     key)
            // then return entry --> contains returns true
            if (e.hash == hash &&
                ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }