//for lists
List<String> stringList = Arrays.asList("1","2","3");
List<Integer> integerList = convertList(stringList, s -> Integer.parseInt(s));

//for arrays
String[] stringArr = {"1","2","3"};
Double[] doubleArr = convertArray(stringArr, Double::parseDouble, Double[]::new);