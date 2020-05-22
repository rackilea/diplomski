public static <T> ConcurrentMap<String,Collection<T>> reduceMap(ConcurrentMap<String, ConcurrentHashMap<String, Collection<T>>> map) {
    ConcurrentMap<String, Collection<T>> smallerMap = new ConcurrentHashMap<String, Collection<T>>();
    for (String material : map.keySet()) {
        for(String genre: map.get(material).keySet()) {
            if (smallerMap.get(genre) == null) {
                smallerMap.put(genre, map.get(material).get(genre));
            }
            else {
                Collection<T> stories = smallerMap.get(genre);
                for (T o : map.get(material).get(genre)) {
                    if (!smallerMap.get(genre).contains(o)) {
                        stories.add(o); // error here
                    }
                }
                smallerMap.put(genre, stories);
            }
        }
    }   
    return smallerMap;
}