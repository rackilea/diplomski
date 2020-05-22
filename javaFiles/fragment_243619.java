List<CompletableFuture<Void>> futures = new ArrayList<>();
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        CompletableFuture<Void> future = 
                CompletableFuture.supplyAsync(call1Supplier, executor)
                .thenAccept(number -> System.out.println("From future is " + number));
        futures.add(future);
    } else {
        CompletableFuture<Void> future = 
                CompletableFuture.supplyAsync(call2Supplier, executor)
                .thenAccept(number -> System.out.println("From future is " + number));
        futures.add(future);
    }
}