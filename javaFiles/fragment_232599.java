if(shortestPathFound) {
    List<Integer> shortestPath = new ArrayList<>();
    Integer node = nodeToBeFound;
    while(node != null) {
        shortestPath.add(node)
        node = parentNodes.get(node);
    }
    Collections.reverse(shortestPath);
}