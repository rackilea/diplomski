List<CompletableFuture<Optional<ModelObject>>> collect = 
    listOfModel.stream()
    .map(CompletableFuture::completedFuture)
    .map(f -> f.thenApplyAsync(
        modelObject -> {
            try {
                return callMethodWithReturnTypeOfOptional(modelObject);
            } catch(Exception e) {
                throw new CompletionException(e);
            }
        },
        executor))
    .collect(Collectors.toList());