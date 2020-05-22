Function<A, Integer> extractBFromA = new Function<A, Integer>() {
  @Override public Integer apply(A input) {
    return input.b;
  }
}
...
Map<String,Integer> res = Maps.transformValues(map, extractBFromA);