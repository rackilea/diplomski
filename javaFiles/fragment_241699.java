void recursive(List<Integer> values, int depth) {
  if (values.size() == depth) {
    // Do the thing you want to do with the values, i.e. the "innermost loop".
  } else {
    // This is intentionally Integer, so that remove removes that value, not the element at that index.
    for (Integer a = 0; a <= 100; ++a) {
      values.add(a);
      recursive(values, depth);
      values.remove(a);
    }
  }
}