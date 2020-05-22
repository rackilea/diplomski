String number = "2 4 3 4 2 4 0";
String[] array = number.split(" ");
TreeMap<Integer,Long> numberMap = Arrays.stream(array)
    .map(s -> Integer.parseInt(s))
    .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
System.out.println(numberMap.descendingMap().firstEntry().getValue());