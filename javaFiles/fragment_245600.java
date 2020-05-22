private Comparator<Edge> getComparatorBasedOnEdgeWeight() {
    return (e1, e2) -> {
        int cmp = Integer.compare(e1.getWeight(), e2.getWeight());
        if (cmp == 0)
            cmp = e1.getNode1().getName().compareTo(e2.getNode1().getName());
        if (cmp == 0)
            cmp = e1.getNode2().getName().compareTo(e2.getNode2().getName());
        return cmp;
    };
}