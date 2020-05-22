private List<List<Double>> splitAtInflectionPoints(List<Double> data) {
    List<List<Double>> split = new LinkedList<>();
    int start = 0;
    for (int i = 1; i < data.size() - 1; i++) {
        double leftSlope = Math.signum(data.get(i) - data.get(i - 1));
        double rightSlope = Math.signum(data.get(i + 1) - data.get(i));
        if (leftSlope != rightSlope) {
            split.add(data.subList(start, i + 1));
            start = i;
        }
    }
    if (start < data.size()) {
        split.add(data.subList(start, data.size()));
    }
    return split;
}

private void test() {
    List<Double> data = Arrays.asList(6.17, 6.13, 6.12, 6.19, 6.2, 6.21, 6.28, 6.17, 6.2, 6.28);
    for (List<Double> run : splitAtInflectionPoints(data)) {
        System.out.println(run);
    }
}