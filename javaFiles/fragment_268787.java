public void printConnectors(Graph<E> g) { // use the generic type Graph<E> here,
                                          // not the raw type Graph
    for (Edge<E> e: g.edges) {
        System.out.println(e.iterator()); 
    }
}