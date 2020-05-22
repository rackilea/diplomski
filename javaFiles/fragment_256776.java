Stream.Builder<Supplier<CanditateInfo>> streamBuilder = Stream.builder();

results.forEach(string-> streamBuilder.accept(() -> this.getCandidatesInfo(string)));

List<CanditateInfo> candidateInfos = streamBuilder.build().map(supplier -> CompletableFuture.supplyAsync(supplier, Executors.newFixedThreadPool(
  results.size()))).collect(Collectors.toList()).stream().map(
     CompletableFuture::join).collect(Collectors.toList());