public void displayArrayMethod(int array[][]) {
    System.out.print(Arrays.stream(array)
              .flatMapToInt(Arrays::stream)
              .mapToObj(String::valueOf)
              .collect(Collectors.joining(",")));
}