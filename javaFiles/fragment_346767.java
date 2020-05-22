void foo(List<String> a, List<Integer> b, List<List<?>> out) {
  List<?> unknownA = a;
  List<?> unknownB = b;
  out.add(a);
  out.add(b);
}