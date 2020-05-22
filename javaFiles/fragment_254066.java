List<List<String>> my2dList =
        IntStream.range(0, 5)
                 .mapToObj(i -> IntStream.range(0, 10)
                                         .mapToObj(j -> Integer.toString(i * 10 + j))
                                         .collect(Collectors.toList()))
                 .collect(Collectors.toList());