public void addkeys(String K, String V) {
    Collection<String> values = keys.get(K);
    if (values == null) {
        values = new HashSet<>();
        keys.put(K, values);
    }
    values.add(V);
}