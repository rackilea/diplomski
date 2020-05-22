String input = "1 2 3\n" +
    "3 1 5\n" +
    "1 9 7";

int[][] matrix = Arrays.stream(input.split("\n"))
    .map(s -> Arrays.stream(s.split(" "))
        .mapToInt(Integer::parseInt)
        .toArray())
    .toArray(int[][]::new);

List<List<Integer>> listOfLists = Arrays.stream(input.split("\n"))
    .map(s -> Arrays.stream(s.split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList()))
    .collect(Collectors.toList());