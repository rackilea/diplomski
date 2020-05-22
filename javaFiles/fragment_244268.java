List<CompletableFuture<Object>> futures =
    tasks.stream()
        .map(task -> CompletableFuture.supplyAsync(() -> businessLogic(task)))
        .collect(Collectors.toList());
try {
    List<Object> results = futures.stream()
        .map(CompletableFuture::join)
        .collect(Collectors.toList());
} catch (CompletionException e) {
    throw e.getCause() instanceof BusinessException?
        new BadRequestException("at least one async task had an exception"): e;
}