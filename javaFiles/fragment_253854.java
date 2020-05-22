public Map<String, MyObject> load() {
    Map<String, MyObject> mymap = new HashMap<>();
    mymap.put(...);
    ...
    return Collections.unmodifiableMap(mymap);
}