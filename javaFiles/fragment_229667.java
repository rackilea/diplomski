CompletableFuture<Void> complete = CompletableFuture.runAsync(() -> {
        throw new RuntimeException();

    }).exceptionally(ex -> {
        System.out.println("Exception handled");
        return null;
    });