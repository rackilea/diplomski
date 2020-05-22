// First group
CompletableFuture<Integer> task11 = CompletableFuture.supplyAsync(() -> 1);
CompletableFuture<Integer> task12 = CompletableFuture.supplyAsync(() -> 42);
CompletableFuture<Integer> task13 = CompletableFuture.supplyAsync(() -> 1729);

// this one will complete after all tasks from the first group complete
CompletableFuture<Void> allFirstTasks = CompletableFuture.allOf(task11, task12, task13);

// Second group will be child tasks from the first group
CompletableFuture<Integer> task21 = allFirstTasks.thenApply(__ ->
        task11.join() + task12.join() + task13.join() // will not block
);