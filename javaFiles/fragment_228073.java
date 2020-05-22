String[] array = {"#data",
    "1 name1",
    "2 name2",
    "3 name3",
    "4 name4",
    "1: 4 2",
    "2: 3 1",
    "3: 2 4",
    "4: 1 3"};
List<String> lst = Arrays.asList(array);
String[][] arr2 = lst.stream().skip(5).limit(lst.size())
    .map(s -> s.split("[:\\s]+")) // the mapper
    .toArray(String[][]::new);