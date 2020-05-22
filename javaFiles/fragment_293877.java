public Collection<Map.Entry<String, Integer>> adjacentNodes(String node) {
    Map<String, Integer> adjacent = map.get(node);
    if(adjacent==null) {
        return new ArrayList<Map.Entry<String, Integer>>();
    }
    return adjacent.entrySet();
}