List<T[]> valuesPerLine = Files.lines(Paths.get(file))  // Stream<String> lines
    .map(separator::splitAsStream)  // Stream<Stream<String>> wordsPerLine
    .map(lineStream -> {
        return lineStream                 // Stream<String> words
            .mapToInt(Integer::parseInt)  // IntStream values
            .mapToObj(T::new)             // Stream<T> valuesAsT
            .toArray(T[]::new);
    })                              // Stream<T[]> valuesPerLine
    .collect(Collectors.toList());