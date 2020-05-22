ForkJoinPool fjp = new ForkJoinPool(100);
List<CompletableFuture<String>> list = Files.lines(path)
    .map(line -> CompletableFuture.supplyAsync(() -> addressName(line), fjp))
    .collect(Collectors.toList());
list.stream().map(CompletableFuture::join)
    .forEach(System.out::println);