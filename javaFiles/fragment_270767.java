final long end = System.nanoTime() + TimeUnit.SECONDS.toNanos(30L);
myDataStructure.stream()
    .filter(e -> System.nanoTime() <= end)
    .forEach(e ->
    {
      ...
    });