class EvanContainer implements Comparable<EvanContainer> {
    double weight;
    int value;

    EvanContainer(double w, int v) { weight = w; value = v; }

    public int compareTo(EvanContainer other) {
        return Double.compare(weight, other.weight);
    } 

}