// result must be effectively final
List<ItemGroup> result = Collections.synchronizedList(new ArrayList<>());
List<ItemGroup> endResult = result;
ScheduledExecutorService delayer = Executors.newScheduledThreadPool(1);
try {
    CompletableFuture<?>[] completableFutures = response.getItemGroupList().stream()
    .map(inPutItemGroup ->
        timeoutAfter(delayer, 50, TimeUnit.MILLISECONDS,
            CompletableFuture.supplyAsync(
                () -> getUpdatedItemGroup(inPutItemGroup), executorService),
            inPutItemGroup)
         .thenAccept(itemGroup -> {
            // this is thread safe, but questionable,
            // e.g. the result list order is not maintained
            if(null != itemGroup) result.add(itemGroup);
         })
    )
    .toArray(CompletableFuture<?>[]::new);

    // this will wait till all threads are completed
    CompletableFuture.allOf(completableFutures).join();
} catch(final Throwable t) {
    String errorMsg = String.format("Exception occurred while executing parallel call");
    log.error(errorMsg, e);
    endResult = response.getItemGroupList();
}
finally {
    delayer.shutdown();
}

Response finalResponse = Response.builder()
    .itemGroupList(endResult)
    .build();