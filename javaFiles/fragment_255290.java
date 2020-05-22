class Result {
  String[] strings;
  int[] numbers;
}

Result someMethod() {
  Result r = new Result();
  r.strings = new String[]{"a","b","c"};
  r.numbers= new int[]{1,2,3};
  return r;
}