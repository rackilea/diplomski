Callable<MessageMetaDataSet> c = ServletScopes.transferRequest(
               () -> messageService.retrieveMessageMetadataSet(x, y));

   CompletableFuture.supplyAsync(
    () -> c.call()
    , executorService);