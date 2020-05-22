public boolean isConnected(String node1, String node2) {
    Map<String, Integer> adjacent = map.get(node1);
    if(adjacent==null) {
        return false;
    }
    return adjacent.containsKey(node2);
}