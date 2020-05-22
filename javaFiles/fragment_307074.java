public static Map<String, WordCount> getCounts(String[] tokens) {
    Map<String, WordCount> map = new TreeMap<String, WordCount>();

    for(String t : tokens) {
        WordCount count = map.get(t);
        if(count == null) {
            count = new WordCount(t);
            map.put(t, count);
        }

        count.increment();
    }

    return map;
}