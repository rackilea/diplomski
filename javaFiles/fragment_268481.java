class MultipleByTwoIteration extends MappingClass {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2 ,3, 4, 5, 6);

        List<Integer> multipledByTwo =
            numbers.stream().map(x -> x * 2).collect(Collectors.toList());
    }
}