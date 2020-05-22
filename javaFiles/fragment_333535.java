ArrayList<Double> sets;
public Data(double[] sets) {
    this.sets = new ArrayList<Double>();
    for (double d : sets) {
        this.sets.add(d);
    }
}