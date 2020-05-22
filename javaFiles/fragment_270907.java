public void put(String string) {
    List<String> list = map.computeIfAbsent(string, k -> new ArrayList<>());
    synchronized(list) {
       list.add("add something");
    }
}