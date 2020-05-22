<T> getThing(Function<Form, T> extractor, T... forms) {
  for (T form : forms) {
    if (form != null) {
      T thing = extractor.apply(form);
      if (thing != null) return thing;
    }
  }
  return null;
}