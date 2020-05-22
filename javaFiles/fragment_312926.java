@Test public void yourTest() {
  // ...
  verify(dataProcessor).process(anyStringSetMap());
}

private static Map<String, Set<String>> anyStringSetMap() {
  return any();
}