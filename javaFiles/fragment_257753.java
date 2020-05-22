class MyWeightComp implements Comparator<Edge> {

    @Override
    public int compare(Edge e1, Edge e2) {
        int cmp = Integer.compare(e1.weight, e2.weight); // handle overflows.
        if (cmp == 0)
            cmp = Integer.compare(e1.source, e2.source);
        if (cmp == 0)
            cmp = Integer.compare(e1.destination, e2.destination);
        return cmp;
    }
}