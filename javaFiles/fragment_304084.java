Double[][] array;
List<List<Double>> list = Lists.transform(Arrays.asList(array),
  new Function<Double[], List<Double>>() {
    @Override public List<Double> apply(Double[] row) {
      return Arrays.asList(row);
    }
  }
}