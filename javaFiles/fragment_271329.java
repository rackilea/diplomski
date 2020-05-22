if ( mapSize >= maximumSize ) {

        // don't retire LRU if you are just
        // updating an existing key
        if (!containsKey(key)) {
            // lets retire the least recently used item in the cache
           removeLRU();
        }
    }