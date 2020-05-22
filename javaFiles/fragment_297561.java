static Integer head(final List<Integer> is) {
  return is == null || is.isEmpty()? null : is.get(0);
}
static List<Integer> tail(final List<Integer> is) {
  return is.size() < 2? null : is.subList(1, is.size());
}