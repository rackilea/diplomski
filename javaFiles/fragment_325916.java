final List<B> list4 = Arrays.stream(array)
    .map(SomeClass::mapA2B)
    .collect(toCollection(() -> new ArrayList<>(array.length)));    

private static B mapA2B(A a) {
  return new B(a.getIntValue(), a.getStringValue());
}