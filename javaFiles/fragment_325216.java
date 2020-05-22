BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

List<List<Integer>> matrix = reader.lines()
    .takeWhile(line -> !line.equals("end"))
    .map(line -> Arrays.stream(line.split(" "))
        .map(Integer::valueOf)
        .collect(Collectors.toList()))
    .collect(Collectors.toList());