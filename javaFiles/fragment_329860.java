public static void main (String[] args) throws java.lang.Exception {
    int arr [] =  {3,4,5,6,7};
    IntStream.of(arr)
          .filter(i -> i % 2 == 0)
          .sorted()
          .map(j -> j+ 1)
          .forEach(System.out::println);
}