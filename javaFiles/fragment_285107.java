public static class Pair implements Comparable<Pair>{
    int node;
    Double weight;
    public Pair(int node,double weight){
        this.node = node;
        this.weight = weight;
    }


    @Override
    public int compareTo(Pair o) {
        return this.weight.compareTo(o.weight);
    }
}