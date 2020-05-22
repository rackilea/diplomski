public static void main(final String[] args) throws IOException {
    final List<double[]> row = new ArrayList<double[]>();

    row.add(new double[]{10.0, 5.0, 200.3});
    row.add(new double[]{9.1, 1.4, 3.3});
    row.add(new double[]{9.1, 1.4, 3.3});

    final List<double[]> sorted = row.stream().
            sorted((l, r) -> Double.compare(l[2], r[2])).
            collect(Collectors.toList());
}