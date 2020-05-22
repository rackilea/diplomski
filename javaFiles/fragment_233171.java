public static void main(String[] args) {
    String[] wordArray = "this is my string".split(" ");
    Set<String> result = new HashSet<>();
    int n = wordArray.length;
    for (int i = 0; i < n; i++) {
       for (int j = i; j < n; j++) {
            result.add(
                IntStream.rangeClosed(i, j)
                    .mapToObj(v -> wordArray[v])
                    .collect(Collectors.joining(" ")));
        }
    }
    result.forEach(System.out::println);
}