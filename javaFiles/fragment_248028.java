private void test(List<Object> list, int chunkSize) throws ExecutionException, InterruptedException {
    AtomicInteger prev = new AtomicInteger(0);
    List<CompletableFuture> futures = new ArrayList<>();
    IntStream.range(1, (int) (chunkSize * (Math.ceil(Math.abs(list.size() / (double) chunkSize)))))
            .filter(i -> i % chunkSize == 0 || i == list.size())
            .forEach(i -> {
                List<Object> chunk = list.subList(prev.get(), i);
                futures.add(CompletableFuture.runAsync(() -> invokeList(chunk)));
                prev.set(i);
            });
    CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).get();
}

private void invokeList(List<Object> list) {
    System.out.println("Invoked for: " + list);
}