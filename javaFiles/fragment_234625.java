public CompletableFuture<List<Document>> getMongoDocuments() throws InterruptedException, ExecutionException {
    CompletableFuture<List<Document>> future = new CompletableFuture<>();
    List<Document> list = new ArrayList<>();

    collection.find().forEach((document) -> {
      try {
        list.add(document);
      } catch (Exception e) {
        LOGGER.error("Error while parsing document::" + document.toString(), e);
      }

    }, (final Void result, final Throwable t) -> {
      future.complete(list);
    });

    List<Document> resultList = future.get(); //Just for testing if everything is as planned
    LOGGER.info("getHighResDocumentsByDriveSessionVinAndLogDate:: Count::" + resultList.size());
    return future;
  }