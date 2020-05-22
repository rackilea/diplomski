CompletableFuture<Void> root = new CompletableFuture<>();
CompletableFuture<Void> child = root.whenComplete((v, t) -> {
    System.out.println(t.getClass()); // class java.io.Exception
});
child.whenComplete((v, t) -> {
    System.out.println(t.getClass()); // class java.util.concurrent.CompletionException
});
root.completeExceptionally(new IOException("blow it up"));