List<List<Integer>> massives = Arrays.stream(str.split("\\R"))  // Stream<String>
    .map(line -> Arrays.stream(line.split("\t"))                  //   Stream<String>
         .map(field -> Integer::valueOf)                          //   Stream<Integer>
         .collect(Collectors.toList()))                           //   List<Integer>
     .collect(Collectors.toList());                             // List<List<Integer>>

List<int[]> massives = Arrays.stream(str.split("\\R"))
     .map(line -> Arrays.stream(line.split("\t"))
         .mapToInt(Integer::parseInt)
         .toArray())
     .collect(Collectors.toList());