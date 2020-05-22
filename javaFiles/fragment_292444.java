static <T> ArrayList<T> stringToList(
    String str, Function<? super String, ? extends T> fn) {
  String[] strs = str.split("\\s");
  ArrayList<T> output = new ArrayList<>();
  for (String val : strs)
  {
      output.add(fn.apply(val));
  }
  return output;
 }