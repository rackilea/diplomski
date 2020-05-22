class MapList {
        Map<K,V> map = new HashMap<K,V>();
        List<K> keysList = new ArrayList<K>();

        public void put(K key, V val) {
            if (!map.contains(key)) {
                keysList.add(key);
            }
            map.put(key, val);
        }

        public void swap(int key1pos, int key2pos) {
            keysList.set(key1pos, keysList.set(key2pos, keysList.get(key1po)));
        }

        // Getter methods, size, etc...
    }