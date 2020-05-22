Boolean or(Collection<Boolean> c) {
  boolean[] b = new boolean[c.size()];
  int i = 0;
  for (Boolean cb : c) {
    b[i++] = cb; // assuming no nulls.
  }
  return or(b);
}