List<Integer> integers =
    IntStream.range(1, 10)                      // <-- creates a stream of ints
        .boxed()                                // <-- converts them to Integers
        .collect(Collectors.toList());          // <-- collects the values to a list

Collections.shuffle(integers);

System.out.println(integers);