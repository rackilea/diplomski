public static void main(String args[]) throws Exception {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    Set<Future<Integer>> set = new HashSet<Future<Integer>>();
    for (String word: args) {
      Callable<Integer> callable = new WordLengthCallable(word);
      Future<Integer> future = pool.submit(callable);
      set.add(future);
    }
    int sum = 0;
    for (Future<Integer> future : set) {
      sum += future.get();
    }
    System.out.printf("The sum of lengths is %s%n", sum);
    System.exit(sum);
  }