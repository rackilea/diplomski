CompletableFuture.anyOf(
            CompletableFuture.supplyAsync(() -> getDataFromDB(clientData)),
            CompletableFuture.supplyAsync(() -> getDataFromApi(clientData)))
            .thenApply(item -> (String) item)
            .thenAccept(result -> {
                // Consume the data
                System.out.println(result);
            });