List<CompletableFuture<Optional<ModelObject>>> collect = 
    listOfModel.stream()
    .map(modelObject -> CompletableFuture.supplyAsync(
        ()-> {
            try {
                return callMethodWithReturnTypeOfOptional(modelObject);
            } catch(Exception e) {
                throw new CompletionException(e);
            }
        },
        executor))
    .collect(Collectors.toList());