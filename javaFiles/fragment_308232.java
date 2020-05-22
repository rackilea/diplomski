Map<Integer, Collection<Integer>> adj = new HashMap<>();

public void addEdge(int source, int destination) {
    //see if adj contains source already
    Collection<Integer> destinations = adj.get(source);
    //if not add in a new LinkedHashSet
    if (destinations == null) {
        destinations = new LinkedHashSet<>();
        adj.put(source, destinations);
    }
    //Set returns false if item exists
    if (!destinations.add(destination)) {
        System.out.println("This mapping already exists.");
    }
}