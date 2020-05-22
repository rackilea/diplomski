public String getString(Object yourObject) {
  if (Objects.isNull(yourObject)) { // or use requireNonNull instead if NullPointerException suffices
     throw new MyCustomException();
  }
  String result = ...
  // your string mapping function
  return result;
}