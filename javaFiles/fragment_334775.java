PriorityQueue<CompletableFuture<String>> queue
 = new PriorityQueue<>(Comparator.comparing(f -> !f.isDone()));

queue.add(CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(Integer.MAX_VALUE);
    } catch (InterruptedException e) {  }

    return "42";
}));

queue.add(CompletableFuture.completedFuture("completed"));

queue.poll(); // "completed"
queue.poll(); // still going on