List<Entry<K,V>> sorted = new ArrayList<>(map.entrySet());
Collections.sort(sorted, new Comparator<Entry<K,V>>() {
    public int compare(Entry<K,V> o1, Entry<K,V> o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
};