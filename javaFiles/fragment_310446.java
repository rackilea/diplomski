List<Future<?>> tasks = new ArrayList<>();
for (String id : ids) {
    Future<?> task = executorService.submit(() -> {
        // do work
    });
    tasks.add(task);
}

long pending = tasks.stream().filter(future -> !future.isDone()).count();
System.out.println(pending + " task are still pending");