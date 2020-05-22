public List<Double> toList(double[] doubles) {
    List<Double> list = new ArrayList<>(doubles.length);
    for (double x : doubles) {
        list.add(x);
    }
    return list;
}