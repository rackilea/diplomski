private <T> void methodA (Map<Integer, Set<T>> inOutMap, Integer key, T value) {

        Set<T> list = new HashSet<T>();

        if (!inOutMap.containsKey(key)) {
            list.add(value);
        } else {
            list = inOutMap.get(key); 
            list.add(value);
        }

        inOutMap.put(key, list); 
    }