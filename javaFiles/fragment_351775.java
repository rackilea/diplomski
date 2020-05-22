public static int count(List list) {
  int sum = 0;
  for(Object o: list) {
     sum += o instanceof List ? count((List) o) : 1;
  }
  return sum;
}