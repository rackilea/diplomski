CompletableFuture<String> a = …, b = …, c = …;
CompletableFuture<Void> allWithFailFast = CompletableFuture.allOf(a, b, c);
Stream.of(a, b, c)
    .forEach(f -> f.exceptionally(e -> {
        allWithFailFast.completeExceptionally(e);
        return null;
    }));