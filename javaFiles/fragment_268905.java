CompletableFuture.allOf(a).whenComplete((r, e) -> {
    for (CompletableFuture<String> future : a) {
        try {
           System.out.println(future.get());
        }
        catch (InterruptedException | ExecutionException e1) {
           e1.printStackTrace();
        }
    }
});