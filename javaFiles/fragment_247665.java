List<String> firstList = Arrays.asList("hello", "world");
List<String> secondList = Arrays.asList("hello", "dolly");
faultyMethod(firstList, secondList);
return secondList.isEmpty()
  ? firstList
  : secondList;