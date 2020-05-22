public static Map<String, Set<String>> reverse (Map <String, Set<String>> graph) {
    Map<String, Set<String>> result = new HashMap<String, Set<String>>();
    for (Map.Entry<String, Set<String>> graphEntry: graph.entrySet()) {
        for (String graphValue: graphEntry.getValue()) {
            Set<String> set = result.get(graphValue);
            if (set == null) {
                set = new HashSet<String>();
                result.put(graphValue, set);
            }
            set.add(graphEntry.getKey());
        }
    }
    return result;
}