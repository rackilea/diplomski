final int parallelism = 4;
ForkJoinPool forkJoinPool = null;
try {
    forkJoinPool = new ForkJoinPool(parallelism);
    final List<Integer> primes = forkJoinPool.submit(() ->
        // Parallel task here, for example
        IntStream.range(1, 1_000_000).parallel()
                .filter(PrimesPrint::isPrime)
                .boxed().collect(Collectors.toList())
    ).get();
    System.out.println(primes);
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
} finally {
    if (forkJoinPool != null) {
        forkJoinPool.shutdown();
    }
}