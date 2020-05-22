IntStream.range(0, lines.size()).parallel()
    .mapToObj(i -> {
        String line = lines.get(i);
        ...
        return new int[] { i, sum5, sum7 };
    });