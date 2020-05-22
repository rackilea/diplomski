String file = ...
Pattern separator = Pattern.compile("\\s");

try (Stream<String> lines = Files.lines(Paths.get(file))) {
    T[] values = lines                      // Stream<String> lines
        .flatMap(separator::splitAsStream)  // Stream<String> words
        .mapToInt(Integer::parseInt)        // IntStream values
        .mapToObj(T::new)                   // Stream<T> valuesAsT
        .toArray(T[]::new);
} catch (IOException e) {
    System.out.println("Something went wrong.");
}