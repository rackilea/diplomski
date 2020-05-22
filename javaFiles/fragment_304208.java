if (adjacencyList.containsKey(keyNow)) {
    Iterator<Integer> iter = adjacencyList.get(keyNow).iterator();
    while (iter.hasNext()) {
        Integer w = iter.next();
        iter.remove();
    }
}