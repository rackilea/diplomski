String[][] keys = {
        {"A","1"},
        {"A","2"},
        {"A","3"},
        {"B","1"},
        {"B","2"},
        {"B","3"},
    };
    String[][] result = Stream.of(keys)
        .filter(x -> x[0].equals("A"))
        .toArray(String[][]::new);
    System.out.println(Arrays.deepToString(result));