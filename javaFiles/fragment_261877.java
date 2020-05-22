Supplier<Function<Integer, Integer>> toUse = () -> right();
 Function<Integer, Integer> fib = curry(toUse);
 IntStream.range(1, 11)
          .mapToObj(Integer::valueOf)
          .map(fib)
          .forEach(System.out::println);