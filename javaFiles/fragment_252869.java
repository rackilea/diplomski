public static void main(String[] args) {
    List<Integer> numbers1 = Arrays.asList(1,2,3);
    List<Integer> numbers2 = Arrays.asList(3,4);

    List<List<Integer>> intPairs = numbers1.stream()
            .flatMap(i -> numbers2.stream()
                    .filter(j -> (i+j)%3 == 0)
                    .map(j -> Arrays.asList(i,j)))
                    .collect(Collectors.toList());
    intPairs.stream().forEach(System.out::println);
}