public boolean hasDependencies(Map<String, Set<String>> objectAndItsDependentsMap) {
    for (String node : objectAndItsDependentsMap.keySet()) {
        final Set<String> directNeighbors = objectAndItsDependentsMap.get(node);
        for (String directNeighbor : directNeighbors) {
            Set<String> next = objectAndItsDependentsMap.get(directNeighbor);
            while (next != null) {
                for (String n : next) {
                    next = objectAndItsDependentsMap.get(n);
                    if (next != null && (next.contains(n) || next.contains(node))) {
                        return true;
                    }
                }
            }
        }
    }
    return false;
}